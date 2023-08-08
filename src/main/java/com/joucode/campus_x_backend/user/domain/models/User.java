package com.joucode.campus_x_backend.user.domain.models;

import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleEntity;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String userName;

    private String email;

    private String password;

    private List <RoleEntity> roles ;
}
