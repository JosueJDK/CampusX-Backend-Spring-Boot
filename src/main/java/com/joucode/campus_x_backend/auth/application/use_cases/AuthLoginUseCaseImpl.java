package com.joucode.campus_x_backend.auth.application.use_cases;

import com.joucode.campus_x_backend.auth.application.services.JwtService;
import com.joucode.campus_x_backend.auth.domain.models.Auth;
import com.joucode.campus_x_backend.auth.domain.ports.input.AuthLoginUseCase;
import com.joucode.campus_x_backend.common.exceptions.NotAuthorizationInvalidException;
import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import com.joucode.campus_x_backend.user.domain.models.enums.ActivityStatusName;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

@AllArgsConstructor
public class AuthLoginUseCaseImpl implements AuthLoginUseCase {

    private final UserRepositoryPort userRepositoryPort;

    private final PasswordEncoder encryptService;

    private final JwtService jwtService;

    @Override
    public Auth authLogin(User user) {
        User userGet = userRepositoryPort.findByEmailOrUsername(user.getEmail(), user.getUsername())
                .orElseThrow(() -> new NotFoundException("El usuario no existe."));

        if (!encryptService.matches(user.getPassword(), userGet.getPassword())) {
            throw new NotAuthorizationInvalidException("Credenciales incorrectas");
        }

        if (userGet.isBanned()) {
            throw new NotAuthorizationInvalidException("User account with login has been banned.");
        }

        if (!userGet.isVerifiedAccount()) {
            throw new NotAuthorizationInvalidException("User account with login: " + userGet.getUsername() + " has not been activated");
        }

        userGet.setActivityStatus(ActivityStatusName.ONLINE);

        userRepositoryPort.save(userGet);

        List<String> rolesNames = userGet.getRoles().stream().map(role -> role.getName()).toList();

        Map<String, String> tokens = jwtService.generateTokens(userGet.getUserId().toString(), user.getUsername(), rolesNames);


        return new Auth(userGet, tokens.get("accessToken"), tokens.get("refreshToken"));
    }







}