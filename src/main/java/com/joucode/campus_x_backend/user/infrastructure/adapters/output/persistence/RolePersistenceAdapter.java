package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence;

import com.joucode.campus_x_backend.user.domain.ports.output.RoleRepositoryPort;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.enums.RoleName;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RolePersistenceAdapter implements RoleRepositoryPort {

    private final RoleRepository roleRepository;

    @Override
    public Optional<RoleEntity> findByName(RoleName roleName) {
        return roleRepository.findByName(roleName);
    }

}
