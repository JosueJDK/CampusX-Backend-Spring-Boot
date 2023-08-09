package com.joucode.campus_x_backend.user.domain.ports.output;

import com.joucode.campus_x_backend.user.domain.models.Role;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleEntity;
import com.joucode.campus_x_backend.user.domain.models.enums.RoleName;

import java.util.Optional;

public interface RoleRepositoryPort {

    Optional<Role> findByName(RoleName roleName);

}
