package com.joucode.campus_x_backend.user.domain.ports.output;

import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleName;

public interface RoleRepositoryPort {

    RoleEntity findByName(RoleName roleName);

}
