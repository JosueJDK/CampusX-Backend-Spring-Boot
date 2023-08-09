package com.joucode.campus_x_backend.common.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUserName {
    String message() default "Username already exists.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload()default {};
}
