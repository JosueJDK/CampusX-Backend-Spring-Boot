package com.joucode.campus_x_backend.auth.domain.ports.output;

import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;

import java.util.Optional;

public interface AuthRepositoryPort {

    UserEntity save(User user);

    Optional<UserEntity> findByEmail(String email) throws NotFoundException;

    Optional<UserEntity> findByUserName(String user_name) throws NotFoundException;

    Boolean existsByEmail(String email);

    Boolean existsByUserName(String userName);
}
