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

    @NotBlank
    private String login;

    @NotBlank
    private String password;

}
