package com.joucode.campus_x_backend.auth.application.use_cases;

import com.joucode.campus_x_backend.auth.application.services.JwtService;
import com.joucode.campus_x_backend.auth.domain.models.Auth;
import com.joucode.campus_x_backend.auth.domain.ports.input.AuthLoginUseCase;
import com.joucode.campus_x_backend.auth.domain.ports.output.AuthRepositoryPort;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.mappers.AuthMapper;
import com.joucode.campus_x_backend.common.exceptions.CredentialsInvalidException;
import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class AuthLoginUseCaseImpl implements AuthLoginUseCase {

    private final AuthRepositoryPort authRepositoryPort;

    private final AuthMapper authMapper;

    private final PasswordEncoder encryptService;

    private final JwtService jwtService;

    @Override
    public Auth authLogin(User user) {
        Optional<UserEntity> userEntityOptional = authRepositoryPort.findByEmail(user.getEmail());

        if (userEntityOptional.isEmpty()) {
            throw new NotFoundException("El usuario con el email " + user.getEmail() + " no fue encontrado.");
        }

        User userSearch = authMapper.toUser(userEntityOptional.get());

        if (!encryptService.matches(user.getPassword(), userSearch.getPassword())) {
            throw new CredentialsInvalidException("Credenciales incorrectas");
        }

        List<String> rolesNames = new ArrayList<>();
        userSearch.getRoles().forEach(r -> rolesNames.add(r.getRoleName()));

        Map<String, String> getTokens = jwtService.generateTokens(userSearch.getEmail(), rolesNames, "access_token");

        return authMapper.toAuth(userSearch, getTokens.get("accessToken"), getTokens.get("refreshToken"));
    }



}