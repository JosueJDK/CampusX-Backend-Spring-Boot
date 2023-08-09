package com.joucode.campus_x_backend.common.annotations;

import com.joucode.campus_x_backend.auth.application.services.AuthService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUserName,String> {
    private AuthService authService;

    @Autowired
    public UniqueUsernameValidator(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void initialize(UniqueUserName uniqueUserName) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        Boolean isExistUserName = this.authService.checkAvailableUserName(username);
        return isExistUserName == false;
    }
}
