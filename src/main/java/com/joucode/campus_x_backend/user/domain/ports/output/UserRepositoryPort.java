package com.joucode.campus_x_backend.user.domain.ports.output;

import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String email);

    Optional<User> findByEmailOrUsername (String email, String username);

    Boolean existsByEmail(String email);

    Boolean existsByUserName(String userName);

}
