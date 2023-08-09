package com.joucode.campus_x_backend.auth.application.use_cases;

import com.joucode.campus_x_backend.auth.application.services.JwtService;
import com.joucode.campus_x_backend.auth.domain.models.Auth;
import com.joucode.campus_x_backend.auth.domain.ports.input.AuthRefreshTokenUseCase;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.mappers.AuthMapper;
import com.joucode.campus_x_backend.common.exceptions.CustomAuthenticationException;
import com.joucode.campus_x_backend.common.exceptions.GlobalException;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.enums.ActivityStatusName;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class AuthRefreshTokenUseCaseImpl implements AuthRefreshTokenUseCase {

    private final UserRepositoryPort userRepositoryPort;

    private final AuthMapper authMapper;

    private final JwtService jwtService;

    @Override
    public Auth refreshToken(String refreshToken) {
        try {
            if (jwtService.validateToken(refreshToken)) {
                if (jwtService.extractTypeToken(refreshToken).equals("refresh_token") && !jwtService.isTokenExpired(refreshToken)) {
                    String usernameOrEmail = jwtService.extractUsernameOrEmail(refreshToken);

                    UserEntity userEntity = userRepositoryPort.findByEmailOrUsername(usernameOrEmail, usernameOrEmail)
                            .orElseThrow(() -> new UsernameNotFoundException("Not Found user with this username: " + usernameOrEmail));

                    if(userEntity.getActivityStatus() != ActivityStatusName.ONLINE){
                        throw new GlobalException("Internal Server Error");
                    }else {
                        List<String> rolesNames = authMapper.toRoleNames(new ArrayList<>(userEntity.getRoles()));

                        Map<String, String> tokens = jwtService.generateTokens(userEntity.getUserId().toString(), usernameOrEmail, rolesNames);

                        return authMapper.toAuth(authMapper.toUser(userEntity), tokens.get("accessToken"), tokens.get("refreshToken"));
                    }

                }
            }
            return new Auth();
        }catch (CustomAuthenticationException e){
            throw new CustomAuthenticationException(e.getMessage());
        }

    }
}
