package com.joucode.campus_x_backend.user.domain.ports.output;

import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.user.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    Optional<User> findByEmail(String email) throws NotFoundException;

    Optional<User> findByUserName(String email) throws NotFoundException;

    Boolean existsByEmail(String email);

    Boolean existsByUserName(String userName);

}
