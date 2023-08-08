package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    RoleName roleName ;

    public RoleEntity(RoleName roleName) {this.roleName = roleName;}

    public String getRoleName() {
        return roleName.toString();
    }
}
