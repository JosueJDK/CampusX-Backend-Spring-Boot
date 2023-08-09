package com.joucode.campus_x_backend.auth.application.use_cases;

import com.joucode.campus_x_backend.auth.application.services.JwtService;
import com.joucode.campus_x_backend.auth.domain.models.Auth;
import com.joucode.campus_x_backend.auth.domain.ports.input.AuthLoginUseCase;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.mappers.AuthMapper;
import com.joucode.campus_x_backend.common.exceptions.NotAuthorizationInvalidException;
import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

@AllArgsConstructor
public class AuthLoginUseCaseImpl implements AuthLoginUseCase {

    private final UserRepositoryPort userRepositoryPort;

    private final AuthMapper authMapper;

    private final PasswordEncoder encryptService;

    private final JwtService jwtService;

    @Override
    public Auth authLogin(User user) {
        UserEntity userEntity = userRepositoryPort.findByEmailOrUsername(user.getEmail(), user.getUsername())
                .orElseThrow(() -> new NotFoundException("El usuario no existe."));

        if (!encryptService.matches(user.getPassword(), userEntity.getPassword())) {
            throw new NotAuthorizationInvalidException("Credenciales incorrectas");
        }

        if (userEntity.isBanned()) {
            throw new NotAuthorizationInvalidException("User account with login has been banned.");
        }

        if (!userEntity.isVerifiedAccount()) {
            throw new NotAuthorizationInvalidException("User account with login: " + userEntity.getUsername() + " has not been activated");
        }


        User mappedUser = authMapper.toUser(userEntity);

        List<String> rolesNames = authMapper.toRoleNames(new ArrayList<>(userEntity.getRoles()));

        Map<String, String> tokens = jwtService.generateTokens(mappedUser.getUserId().toString(), user.getUsername(), rolesNames);


        return authMapper.toAuth(mappedUser, tokens.get("accessToken"), tokens.get("refreshToken"));
    }







}