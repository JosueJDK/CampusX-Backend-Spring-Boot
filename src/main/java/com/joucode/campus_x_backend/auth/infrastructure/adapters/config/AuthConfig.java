package com.joucode.campus_x_backend.auth.infrastructure.adapters.config;

import com.joucode.campus_x_backend.auth.application.services.AuthService;
import com.joucode.campus_x_backend.auth.application.services.JwtService;
import com.joucode.campus_x_backend.auth.application.use_cases.*;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.mappers.AuthMapper;
import com.joucode.campus_x_backend.user.domain.ports.output.RoleRepositoryPort;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthConfig {

    @Bean
    public AuthMapper authMapper(){

        return new AuthMapper();

    }

    @Bean
    public AuthService authService(

            UserRepositoryPort userRepositoryPort,
            RoleRepositoryPort roleRepositoryPort,
            AuthMapper authMapper,
            JwtService jwtService,
            PasswordEncoder encryptService

    ){
        return new AuthService(

                new AuthLoginUseCaseImpl(
                        userRepositoryPort,
                        authMapper,
                        encryptService,
                        jwtService
                ),

                new AuthRegisterUseCaseImpl(
                        userRepositoryPort,
                        roleRepositoryPort,
                        authMapper,
                        encryptService,
                        jwtService
                ),

                new AuthCheckAvailableEmailUseCaseImpl(
                        userRepositoryPort
                ),

                new AuthCheckAvailableUserNameUseCaseImpl(
                        userRepositoryPort
                ),

                new AuthRefreshTokenUseCaseImpl(
                        userRepositoryPort,
                        authMapper,
                        jwtService
                ),

                new AuthLogoutUserIdUseCaseImpl(
                        userRepositoryPort,
                        authMapper
                )

        );
    }

}
