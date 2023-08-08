package com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthLoginRequest {

    private String userName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

}
