package com.joucode.campus_x_backend.common.exceptions;

import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationException extends AuthenticationException {
    public CustomAuthenticationException(String message) {
        super(message);
    }
}