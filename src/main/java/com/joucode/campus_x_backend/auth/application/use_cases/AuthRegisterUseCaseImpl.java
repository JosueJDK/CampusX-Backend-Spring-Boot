package com.joucode.campus_x_backend.auth.application.use_cases;

import com.joucode.campus_x_backend.auth.application.services.JwtService;
import com.joucode.campus_x_backend.auth.domain.models.Auth;
import com.joucode.campus_x_backend.auth.domain.ports.input.AuthRegisterUseCase;
import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.user.domain.models.Role;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.domain.ports.output.RoleRepositoryPort;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import com.joucode.campus_x_backend.user.domain.enums.RoleName;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.*;

@AllArgsConstructor
public class AuthRegisterUseCaseImpl implements AuthRegisterUseCase {

    private final UserRepositoryPort userRepositoryPort;

    private final RoleRepositoryPort roleRepositoryPort;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    @Override
    public Auth authRegister(User user) {
        Role userRole = roleRepositoryPort.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new NotFoundException("Not found role: ROLE_USER"));

        user.setRoles(Collections.singleton(userRole));

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User userCreated = userRepositoryPort.save(user);

        Map<String, String> tokens = jwtService.generateTokens(userCreated.getUserId().toString(), userCreated.getUsername(), Collections.singletonList(userRole.getName()));

        return new Auth(userCreated, tokens.get("accessToken"), tokens.get("refreshToken"));

    }


}
