package com.joucode.campus_x_backend.auth.application.use_cases;

import com.joucode.campus_x_backend.auth.domain.ports.input.AuthCheckAvailableEmailUseCase;
import com.joucode.campus_x_backend.auth.domain.ports.output.AuthRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthCheckAvailableEmailUseCaseImpl implements AuthCheckAvailableEmailUseCase {

    private final AuthRepositoryPort authRepositoryPort;

    @Override
    public Boolean checkAvailableEmail(String email) {
        return authRepositoryPort.existsByEmail(email);
    }
}
