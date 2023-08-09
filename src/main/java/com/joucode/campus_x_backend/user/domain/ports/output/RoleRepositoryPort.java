package com.joucode.campus_x_backend.user.domain.ports.output;

import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.enums.RoleName;

import java.util.Optional;

public interface RoleRepositoryPort {

    Optional<RoleEntity> findByName(RoleName roleName);

}
