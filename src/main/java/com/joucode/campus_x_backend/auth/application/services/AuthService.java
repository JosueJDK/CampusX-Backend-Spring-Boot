package com.joucode.campus_x_backend.auth.application.services;

import com.joucode.campus_x_backend.auth.domain.models.Auth;
import com.joucode.campus_x_backend.auth.domain.ports.input.*;
import com.joucode.campus_x_backend.user.domain.models.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@AllArgsConstructor
public class AuthService
        implements  AuthLoginUseCase,
                    AuthRegisterUseCase,
                    AuthCheckAvailableEmailUseCase,
                    AuthCheckAvailableUserNameUseCase,
                    AuthRefreshTokenUseCase,
                    AuthLogoutUserIdUseCase {

    private final AuthLoginUseCase authLoginUseCase;

    private final AuthRegisterUseCase authRegisterUseCase;

    private final AuthCheckAvailableEmailUseCase authCheckAvailableEmailUseCase;

    private final AuthCheckAvailableUserNameUseCase authCheckAvailableUserNameUseCase;

    private final AuthRefreshTokenUseCase authRefreshTokenUseCase;

    private final AuthLogoutUserIdUseCase authLogoutUserIdUseCase;

    @Override
    public Auth authLogin(User user) {
        return authLoginUseCase.authLogin(user);
    }

    @Override
    public Auth authRegister(User user) {
        return authRegisterUseCase.authRegister(user);
    }

    @Override
    public Boolean checkAvailableEmail(String email) {
        return authCheckAvailableEmailUseCase.checkAvailableEmail(email);
    }

    @Override
    public Boolean checkAvailableUserName(String userName) {
        return authCheckAvailableUserNameUseCase.checkAvailableUserName(userName);
    }

    @Override
    public Auth refreshToken(String refreshToken) {
        return authRefreshTokenUseCase.refreshToken(refreshToken);
    }

    @Override
    public void authLogoutUserId(Long user_id){
        authLogoutUserIdUseCase.authLogoutUserId(user_id);
    }
}
