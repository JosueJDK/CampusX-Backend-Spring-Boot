package com.joucode.campus_x_backend.auth.domain.ports.input;

import com.joucode.campus_x_backend.auth.domain.models.Auth;
import com.joucode.campus_x_backend.user.domain.models.User;

public interface AuthLoginUseCase {

    Auth authLogin(User user);
}
