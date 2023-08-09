package com.joucode.campus_x_backend.user.domain.ports.input;

import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface RetrieveUserUseCase {

    Optional<UserEntity> getUserById(Long id);

    List<UserEntity> getAllUsers();

}
