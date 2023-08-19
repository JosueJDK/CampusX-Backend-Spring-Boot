package com.joucode.campus_x_backend.user_profile.infrastructure.adapters.config;


import com.joucode.campus_x_backend.user_profile.application.service.UserProfileService;
import com.joucode.campus_x_backend.user_profile.application.use_cases.CreateUserProfileUseCaseImpl;
import com.joucode.campus_x_backend.user_profile.application.use_cases.RetrieveUserProfileUseCaseImpl;
import com.joucode.campus_x_backend.user_profile.domain.ports.output.UserProfileRepositoryPort;
import com.joucode.campus_x_backend.user_profile.infrastructure.adapters.output.persistence.UserProfileAdapterPersistence;
import com.joucode.campus_x_backend.user_profile.infrastructure.adapters.output.persistence.mappers.UserProfileMapper;
import com.joucode.campus_x_backend.user_profile.infrastructure.adapters.output.persistence.repository.UserProfileRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserProfileconfig {

    @Bean
    public UserProfileMapper userProfileMapper(){
        return new UserProfileMapper();
    }

    @Bean
    public UserProfileAdapterPersistence userProfileAdapterPersistence(UserProfileRepository repository, UserProfileMapper mapper){
        return new UserProfileAdapterPersistence(
                repository,
                mapper
        );
    }

    @Bean
    public UserProfileService userProfileService(
            UserProfileRepositoryPort repositoryPort
    ){
        return new UserProfileService(
                new CreateUserProfileUseCaseImpl(repositoryPort),
                new RetrieveUserProfileUseCaseImpl(repositoryPort)
        );
    }

}
