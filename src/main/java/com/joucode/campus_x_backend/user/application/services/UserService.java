package com.joucode.campus_x_backend.user.application.services;

import com.joucode.campus_x_backend.user.domain.ports.input.RetrieveUserUseCase;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserService implements RetrieveUserUseCase {

    private final RetrieveUserUseCase retrieveUserUseCase;

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return retrieveUserUseCase.getUserById(id);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return retrieveUserUseCase.getAllUsers();
    }
}
