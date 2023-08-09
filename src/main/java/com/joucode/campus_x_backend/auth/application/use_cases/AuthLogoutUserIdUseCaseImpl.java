package com.joucode.campus_x_backend.auth.application.use_cases;

import com.joucode.campus_x_backend.auth.domain.ports.input.AuthLogoutUserIdUseCase;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.mappers.AuthMapper;
import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.enums.ActivityStatusName;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthLogoutUserIdUseCaseImpl implements AuthLogoutUserIdUseCase {

    private final UserRepositoryPort userRepositoryPort;

    private final AuthMapper authMapper;

    @Override
    public void authLogoutUserId(Long user_id) {

        UserEntity userEntity = userRepositoryPort.findById(user_id)
                .orElseThrow(() -> new NotFoundException("El usuario no existe."));

        userEntity.setActivityStatus(ActivityStatusName.OFFLINE);

        userRepositoryPort.save(authMapper.toUser(userEntity));

    }
}
