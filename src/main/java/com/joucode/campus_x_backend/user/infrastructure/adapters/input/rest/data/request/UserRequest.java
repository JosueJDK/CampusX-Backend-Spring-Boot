package com.joucode.campus_x_backend.user.infrastructure.adapters.input.rest.data.request;

import com.joucode.campus_x_backend.common.constraints.PasswordConstraint;
import jakarta.validation.constraints.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

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
