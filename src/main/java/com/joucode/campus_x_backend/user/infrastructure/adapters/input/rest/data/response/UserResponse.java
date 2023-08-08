package com.joucode.campus_x_backend.user.infrastructure.adapters.input.rest.data.response;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;

    private String userName;

    private String email;

    private String password;

}
