package com.joucode.campus_x_backend.auth.infrastructure.adapters.config;

import com.joucode.campus_x_backend.auth.application.services.AuthService;
import com.joucode.campus_x_backend.auth.application.services.JwtService;
import com.joucode.campus_x_backend.auth.application.use_cases.*;
import com.joucode.campus_x_backend.auth.domain.ports.output.AuthRepositoryPort;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.AuthPersistenceAdapter;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.mappers.AuthMapper;
import com.joucode.campus_x_backend.user.domain.ports.output.RoleRepositoryPort;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthConfig {

    @Bean
    public AuthPersistenceAdapter persistenceAdapter(

            UserRepository authRepository,
            AuthMapper authMapper

    ) {

        return new AuthPersistenceAdapter(
                authRepository,
                authMapper
        );

    }

    @Bean
    public AuthMapper authMapper(){

        return new AuthMapper();

    }

    @Bean
    public AuthService authService(

            AuthRepositoryPort authRepositoryPort,
            RoleRepositoryPort roleRepositoryPort,
            AuthMapper authMapper,
            JwtService jwtService,
            PasswordEncoder encryptService

    ){
        return new AuthService(

                new AuthLoginUseCaseImpl(
                        authRepositoryPort,
                        authMapper,
                        encryptService,
                        jwtService
                ),

                new AuthRegisterUseCaseImpl(
                        authRepositoryPort,
                        roleRepositoryPort,
                        authMapper,
                        encryptService,
                        jwtService
                ),

                new AuthCheckAvailableEmailUseCaseImpl(
                        authRepositoryPort
                ),

                new AuthCheckAvailableUserNameUseCaseImpl(
                        authRepositoryPort
                )

        );
    }

}
