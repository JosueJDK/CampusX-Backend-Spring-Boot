package com.joucode.campus_x_backend.common.constraints;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConstraint {
    String message() default "El campo debe tener al menos una letra mayúscula, una letra minúscula, un carácter especial y un número.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
