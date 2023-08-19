package com.joucode.campus_x_backend.university.infrastructure.adapters.config;

import com.joucode.campus_x_backend.university.application.services.UniversityService;
import com.joucode.campus_x_backend.university.application.use_cases.CreateUniversityUseCaseImpl;
import com.joucode.campus_x_backend.university.application.use_cases.RetrieveUniversityUseCaseImpl;
import com.joucode.campus_x_backend.university.domain.ports.output.UniversityRepositoryPort;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.UniversityPersistenceAdapter;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.mappers.UniversityMapper;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.respository.UniversityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UniversityConfig {

    @Bean
    public UniversityMapper universityMapper(){
        return new UniversityMapper();
    }

    @Bean
    public UniversityPersistenceAdapter universityPersistenceAdapter(UniversityRepository repository, UniversityMapper mapper){
        return new UniversityPersistenceAdapter(repository, mapper);
    }

    @Bean
    public UniversityService universityService(UniversityRepositoryPort repositoryPort){
        return new UniversityService(
                new CreateUniversityUseCaseImpl(repositoryPort),
                new RetrieveUniversityUseCaseImpl(repositoryPort)
        );
    }

}
