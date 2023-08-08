package com.joucode.campus_x_backend.auth.application.use_cases;

import com.joucode.campus_x_backend.auth.domain.ports.input.AuthCheckAvailableEmailUseCase;
import com.joucode.campus_x_backend.auth.domain.ports.input.AuthCheckAvailableUserNameUseCase;
import com.joucode.campus_x_backend.auth.domain.ports.output.AuthRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthCheckAvailableUserNameUseCaseImpl implements AuthCheckAvailableUserNameUseCase {

    private final AuthRepositoryPort authRepositoryPort;

    @Override
    public Boolean checkAvailableUserName(String userName) {
        return authRepositoryPort.existsByUserName(userName);
    }
}
