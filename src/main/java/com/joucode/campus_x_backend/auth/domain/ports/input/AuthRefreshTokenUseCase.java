package com.joucode.campus_x_backend.auth.domain.ports.input;

import com.joucode.campus_x_backend.auth.domain.models.Auth;

public interface AuthRefreshTokenUseCase {
    Auth refreshToken(String refreshToken);
}
