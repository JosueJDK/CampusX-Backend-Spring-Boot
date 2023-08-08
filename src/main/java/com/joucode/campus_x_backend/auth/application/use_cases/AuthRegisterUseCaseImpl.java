package com.joucode.campus_x_backend.auth.application.use_cases;

import com.joucode.campus_x_backend.auth.application.services.JwtService;
import com.joucode.campus_x_backend.auth.domain.models.Auth;
import com.joucode.campus_x_backend.auth.domain.ports.input.AuthRegisterUseCase;
import com.joucode.campus_x_backend.auth.domain.ports.output.AuthRepositoryPort;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.mappers.AuthMapper;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.domain.ports.output.RoleRepositoryPort;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleName;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class AuthRegisterUseCaseImpl implements AuthRegisterUseCase {

    private final AuthRepositoryPort authRepositoryPort;

    private final RoleRepositoryPort roleRepositoryPort;

    private final AuthMapper authMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;



    @Override
    public Auth authRegister(User user){

        RoleEntity role = roleRepositoryPort.findByName(RoleName.USER);
        user.setRoles(Collections.singletonList(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(passwordEncoder.encode(user.getPassword()));

        User userCreated = authMapper.toUser(authRepositoryPort.save(user));

        List<String> rolesNames = new ArrayList<>();
        userCreated.getRoles().forEach(r-> rolesNames.add(r.getRoleName()));

        Map<String, String> getTokens = jwtService.generateTokens(userCreated.getEmail(), rolesNames, "access_token");
        return authMapper.toAuth(userCreated, getTokens.get("accessToken"), getTokens.get("refreshToken"));
    }
}
