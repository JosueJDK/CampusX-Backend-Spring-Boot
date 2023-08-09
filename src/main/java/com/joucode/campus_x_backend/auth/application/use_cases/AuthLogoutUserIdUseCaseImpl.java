package com.joucode.campus_x_backend.auth.application.use_cases;

import com.joucode.campus_x_backend.auth.domain.ports.input.AuthLogoutUserIdUseCase;
import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import com.joucode.campus_x_backend.user.domain.models.enums.ActivityStatusName;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthLogoutUserIdUseCaseImpl implements AuthLogoutUserIdUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public void authLogoutUserId(Long user_id) {

        User user = userRepositoryPort.findById(user_id)
                .orElseThrow(() -> new NotFoundException("El usuario no existe."));

        user.setActivityStatus(ActivityStatusName.OFFLINE);

        userRepositoryPort.save(user);

    }
}
