package com.joucode.campus_x_backend.auth.infrastructure.adapters.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.joucode.campus_x_backend.common.response.Response;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

  private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

  @Override
  public void commence(HttpServletRequest servletRequest, HttpServletResponse servletResponse, AuthenticationException authException)
      throws IOException, ServletException {

    logger.error("Unauthorized error: {}", authException.getMessage());

    servletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
    servletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    final ObjectMapper mapper = new ObjectMapper();

    Response responseBody = Response.builder()
            .code(UNAUTHORIZED.value())
            .status(UNAUTHORIZED.name())
            .data(Map.of("error", Map.of("message", authException.getMessage()))).build();

    mapper.writeValue(servletResponse.getOutputStream(), responseBody);
  }

}
