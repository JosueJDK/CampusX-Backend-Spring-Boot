package com.joucode.campus_x_backend.auth.application.use_cases;

import com.joucode.campus_x_backend.auth.application.services.JwtService;
import com.joucode.campus_x_backend.auth.domain.models.Auth;
import com.joucode.campus_x_backend.auth.domain.ports.input.AuthRefreshTokenUseCase;
import com.joucode.campus_x_backend.common.exceptions.CustomAuthenticationException;
import com.joucode.campus_x_backend.common.exceptions.GlobalException;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import com.joucode.campus_x_backend.user.domain.enums.ActivityStatusName;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class AuthRefreshTokenUseCaseImpl implements AuthRefreshTokenUseCase {

    private final UserRepositoryPort userRepositoryPort;

    private final JwtService jwtService;

    @Override
    public Auth refreshToken(String refreshToken) {
        try {
            if (jwtService.validateToken(refreshToken)) {
                if (jwtService.extractTypeToken(refreshToken).equals("refresh_token") && !jwtService.isTokenExpired(refreshToken)) {
                    String usernameOrEmail = jwtService.extractUsernameOrEmail(refreshToken);

                    User user = userRepositoryPort.findByEmailOrUsername(usernameOrEmail, usernameOrEmail)
                            .orElseThrow(() -> new UsernameNotFoundException("Not Found user with this username: " + usernameOrEmail));

                    if(user.getActivityStatus() != ActivityStatusName.ONLINE){
                        throw new GlobalException("Internal Server Error");
                    }else {
                        List<String> rolesNames = user.getRoles().stream().map(roleEntity -> roleEntity.getName()).toList();

                        Map<String, String> tokens = jwtService.generateTokens(user.getUserId().toString(), usernameOrEmail, rolesNames);

                        return new Auth(user, tokens.get("accessToken"), tokens.get("refreshToken"));
                    }
                }else{
                    throw new CustomAuthenticationException("Token no valido");
                }
            }
            return null;
        }catch (CustomAuthenticationException e){
            throw new CustomAuthenticationException(e.getMessage());
        }

    }
}
