package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository;

import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleEntity;
import com.joucode.campus_x_backend.user.domain.models.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

    Optional<RoleEntity> findByName(RoleName roleName);

    Boolean existsByName(RoleName roleName);

}
