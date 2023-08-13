package com.joucode.campus_x_backend.user.application.services;

import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.domain.ports.input.RetrieveUserUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserService implements RetrieveUserUseCase {

    private final RetrieveUserUseCase retrieveUserUseCase;

    @Override
    public User getById(Long id) {
        return retrieveUserUseCase.getById(id);
    }

    @Override
    public List<User> getAll() {
        return retrieveUserUseCase.getAll();
    }
}
