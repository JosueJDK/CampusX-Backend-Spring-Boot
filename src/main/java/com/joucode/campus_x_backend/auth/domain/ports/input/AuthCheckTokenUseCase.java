package com.joucode.campus_x_backend.auth.domain.ports.input;

public interface AuthCheckTokenUseCase {
    Boolean checkAvailableToken(String token);
}
