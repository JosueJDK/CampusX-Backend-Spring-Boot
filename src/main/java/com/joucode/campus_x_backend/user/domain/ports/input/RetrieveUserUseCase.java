package com.joucode.campus_x_backend.user.domain.ports.input;

import com.joucode.campus_x_backend.user.domain.models.User;
import java.util.List;

public interface RetrieveUserUseCase {

    User getById(Long id);

    List<User> getAll();

}
