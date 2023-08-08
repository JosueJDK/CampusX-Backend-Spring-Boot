package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence;

import com.joucode.campus_x_backend.user.domain.ports.output.RoleRepositoryPort;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleName;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository.RoleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RolePersistenceAdapter implements RoleRepositoryPort {

    private final RoleRepository roleRepository;

    @Override
    public RoleEntity findByName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
