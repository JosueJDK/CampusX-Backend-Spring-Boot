package com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthCheckEmailRequest {

    @NotBlank
    @Email
    private String email;

}
