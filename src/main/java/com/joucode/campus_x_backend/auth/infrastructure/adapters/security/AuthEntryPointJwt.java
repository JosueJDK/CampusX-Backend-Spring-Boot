package com.joucode.campus_x_backend.auth.infrastructure.adapters.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.joucode.campus_x_backend.common.response.Response;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
      throws IOException, ServletException {

      LOGGER.error("---- Unauthorized error: {}", authException.getMessage());

      response.setContentType(MediaType.APPLICATION_JSON_VALUE);
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

      Response responseBody = new Response();
      responseBody.setCode(UNAUTHORIZED.value());
      responseBody.setStatus(UNAUTHORIZED.name());
      responseBody.setData(Map.of("error", Map.of("message", authException.getMessage())));

      final ObjectMapper mapper = new ObjectMapper();
      mapper.writeValue(response.getOutputStream(), responseBody);
    }

}
