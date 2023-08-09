package com.joucode.campus_x_backend.common.annotations;

import com.joucode.campus_x_backend.auth.application.services.AuthService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,String> {

    private AuthService authService;

    @Autowired
    public UniqueEmailValidator(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        Boolean isExistEmail = this.authService.checkAvailableEmail(email);
        return isExistEmail == false;
    }
}

