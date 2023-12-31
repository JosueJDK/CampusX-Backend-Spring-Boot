package com.joucode.campus_x_backend.user.application.use_cases;

import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.domain.ports.input.RetrieveUserUseCase;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RetrieveUserUseCaseImpl implements RetrieveUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User getById(Long id) {
        return userRepositoryPort.findById(id).orElseThrow(
                () -> new NotFoundException("El usuario no existe.")
        );
    }

    @Override
    public List<User> getAll() {
        return userRepositoryPort.findAll();
    }

}
