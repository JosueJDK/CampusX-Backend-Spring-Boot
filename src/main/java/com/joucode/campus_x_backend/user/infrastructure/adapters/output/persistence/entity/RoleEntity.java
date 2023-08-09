package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity;

import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.enums.RoleName;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "role_table")
public class RoleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "name",length = 20, nullable = false)
    private RoleName name;

}
