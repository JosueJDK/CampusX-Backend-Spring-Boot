package com.joucode.campus_x_backend.auth.infrastructure.adapters.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joucode.campus_x_backend.auth.application.services.JwtService;
import com.joucode.campus_x_backend.common.exceptions.CustomAuthenticationException;
import com.joucode.campus_x_backend.common.response.Response;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Map;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;


@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        String token = jwtService.getToken(request);

        if (token != null) {
            try {
                if(jwtService.validateToken(token)){
                    String email = jwtService.extractUsername(token);
                    UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
                    if (userDetails != null) {
                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
                        log.info("authenticated user with email: {}", email);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            } catch (CustomAuthenticationException e) {
                log.info("Authentication error: {}", e.getMessage());
                handleAuthenticationError(response, e.getMessage());
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void handleAuthenticationError(HttpServletResponse servletResponse, String errorMessage) throws IOException {

        servletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        servletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        final ObjectMapper mapper = new ObjectMapper();

        Response responseBody = Response.builder()
                .code(UNAUTHORIZED.value())
                .status(UNAUTHORIZED.name())
                .data(Map.of("error", Map.of("message", errorMessage)))
                .build();

        mapper.writeValue(servletResponse.getOutputStream(), responseBody);
    }
}
