package com.joucode.campus_x_backend.user.domain.ports.output;

import com.joucode.campus_x_backend.user.domain.models.Role;
import com.joucode.campus_x_backend.user.domain.enums.RoleName;

import java.util.Optional;

public interface RoleRepositoryPort {

    Optional<Role> findByName(RoleName roleName);

}
