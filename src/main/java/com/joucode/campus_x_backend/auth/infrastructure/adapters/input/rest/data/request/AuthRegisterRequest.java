package com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.request;

import com.joucode.campus_x_backend.common.constraints.PasswordConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRegisterRequest {

    @NotBlank
    @Size(min = 1, max = 10)
    private String userName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @PasswordConstraint
    @Size(min = 8, max = 25)
    private String password;

}
