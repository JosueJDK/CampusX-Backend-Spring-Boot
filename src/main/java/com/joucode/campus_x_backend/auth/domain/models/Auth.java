package com.joucode.campus_x_backend.auth.domain.models;

import com.joucode.campus_x_backend.user.domain.models.User;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Auth {

    private User user;

    private String accessToken;

    private String refreshToken;

}
