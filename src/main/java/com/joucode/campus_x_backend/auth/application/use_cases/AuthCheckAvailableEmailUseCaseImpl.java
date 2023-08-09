package com.joucode.campus_x_backend.auth.application.use_cases;

import com.joucode.campus_x_backend.auth.domain.ports.input.AuthCheckAvailableEmailUseCase;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthCheckAvailableEmailUseCaseImpl implements AuthCheckAvailableEmailUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public Boolean checkAvailableEmail(String email) {
        return userRepositoryPort.existsByEmail(email);
    }
}
