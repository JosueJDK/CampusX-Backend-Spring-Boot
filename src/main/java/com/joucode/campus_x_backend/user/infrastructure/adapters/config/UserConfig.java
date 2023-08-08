package com.joucode.campus_x_backend.user.infrastructure.adapters.config;

import com.joucode.campus_x_backend.user.application.services.UserService;
import com.joucode.campus_x_backend.user.application.use_cases.RetrieveUserUseCaseImpl;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.RolePersistenceAdapter;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.UserPersistenceAdapter;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.mappers.UserMapper;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository.RoleRepository;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }

    @Bean
    public UserPersistenceAdapter productPersistenceAdapter(UserRepository userRepository, UserMapper userMapper) {
        return new UserPersistenceAdapter(userRepository, userMapper);
    }

    @Bean
    RolePersistenceAdapter rolePersistenceAdapter(RoleRepository roleRepository){
        return new RolePersistenceAdapter(
                roleRepository
        );
    }

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort){
        return new UserService(
                new RetrieveUserUseCaseImpl(userRepositoryPort)
        );
    }


}
