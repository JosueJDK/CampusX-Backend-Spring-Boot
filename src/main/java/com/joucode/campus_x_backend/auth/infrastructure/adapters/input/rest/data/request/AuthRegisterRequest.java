package com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.request;

import com.joucode.campus_x_backend.common.annotations.UniqueEmail;
import com.joucode.campus_x_backend.common.annotations.UniqueUserName;
import com.joucode.campus_x_backend.user.domain.enums.GenderName;
import jakarta.validation.constraints.*;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRegisterRequest {

    @NotBlank
    @Size(min = 1, max = 10)
    @UniqueUserName
    private String username;

    @NotBlank
    @Email
    @UniqueEmail
    private String email;

    @NotBlank
    @Size(min = 8, max = 25)
    private String password;

    @NotEmpty
    @Positive
    @Size(max = 9)
    private String phoneNumber;

    @NotEmpty
    @Size(max = 100)
    private String firstName;

    @NotEmpty
    @Size(max = 100)
    private String lastName;

    @NotNull
    private GenderName gender;

    @NotEmpty
    private String dateOfBirth;

}
