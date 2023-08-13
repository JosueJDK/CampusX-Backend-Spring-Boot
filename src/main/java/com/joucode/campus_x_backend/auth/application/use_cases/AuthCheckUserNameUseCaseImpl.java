package com.joucode.campus_x_backend.auth.application.use_cases;

import com.joucode.campus_x_backend.auth.domain.ports.input.AuthCheckUserNameUseCase;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthCheckUserNameUseCaseImpl implements AuthCheckUserNameUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public Boolean checkAvailableUserName(String userName) {
        return userRepositoryPort.existsByUserName(userName);
    }
}
