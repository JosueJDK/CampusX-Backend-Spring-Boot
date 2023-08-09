package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence;

import com.joucode.campus_x_backend.user.domain.models.Role;
import com.joucode.campus_x_backend.user.domain.ports.output.RoleRepositoryPort;
import com.joucode.campus_x_backend.user.domain.models.enums.RoleName;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.mappers.UserMapper;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository.RoleRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RolePersistenceAdapter implements RoleRepositoryPort {

    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    @Override
    public Optional<Role> findByName(RoleName roleName) {
        return Optional.ofNullable(userMapper.toRole(roleRepository.findByName(roleName).get()));
    }

}
