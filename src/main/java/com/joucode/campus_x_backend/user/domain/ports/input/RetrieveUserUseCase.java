package com.joucode.campus_x_backend.user.domain.ports.input;

import com.joucode.campus_x_backend.user.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface RetrieveUserUseCase {

    Optional<User> getUserById(Long id);

    List<User> getAllUsers();

}
