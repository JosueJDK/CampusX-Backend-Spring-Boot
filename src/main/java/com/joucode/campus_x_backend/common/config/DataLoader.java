package com.joucode.campus_x_backend.common.config;

import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.respository.UniversityRepository;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleEntity;
import com.joucode.campus_x_backend.user.domain.enums.RoleName;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class DataLoader implements ApplicationRunner {

    private final RoleRepository roleRepository;

    private final UniversityRepository universityRepository;

    @Autowired
    public DataLoader(RoleRepository roleRepository, UniversityRepository universityRepository) {
        this.roleRepository = roleRepository;
        this.universityRepository = universityRepository;
    }

    public void run(ApplicationArguments args) {
        if (!roleRepository.existsByName(RoleName.ROLE_USER) && !roleRepository.existsByName(RoleName.ROLE_ADMIN)) {
            roleRepository.save(new RoleEntity(1L, RoleName.ROLE_USER));
            roleRepository.save(new RoleEntity(2L, RoleName.ROLE_ADMIN));
        }
    }
}