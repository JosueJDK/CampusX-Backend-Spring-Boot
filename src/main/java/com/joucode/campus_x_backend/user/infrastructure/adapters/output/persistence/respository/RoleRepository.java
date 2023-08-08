package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository;

import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

    RoleEntity findByRoleName(RoleName roleName);

}
