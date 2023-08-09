package com.joucode.campus_x_backend.user.domain.ports.output;

import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    UserEntity save(User user);

    Optional<UserEntity> findById(Long id);

    List<UserEntity> findAll();

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUserName(String email);

    Optional<UserEntity> findByEmailOrUsername (String email, String username);

    Boolean existsByEmail(String email);

    Boolean existsByUserName(String userName);

}
