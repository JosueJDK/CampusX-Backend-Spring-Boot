package com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthResponse {

    private String userName;

    private String email;

    private String password;

    private String accessToken;

}
