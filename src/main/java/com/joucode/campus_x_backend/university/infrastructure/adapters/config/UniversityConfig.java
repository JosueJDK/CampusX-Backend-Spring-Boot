package com.joucode.campus_x_backend.university.infrastructure.adapters.config;

import com.joucode.campus_x_backend.university.application.services.SpecialtyService;
import com.joucode.campus_x_backend.university.application.services.UniversityService;
import com.joucode.campus_x_backend.university.application.use_cases.specialty.CreateSpecialtyUseCaseImpl;
import com.joucode.campus_x_backend.university.application.use_cases.specialty.RetrieveSpecialtyUseCaseImpl;
import com.joucode.campus_x_backend.university.application.use_cases.university.CreateUniversityUseCaseImpl;
import com.joucode.campus_x_backend.university.application.use_cases.university.RetrieveUniversityUseCaseImpl;
import com.joucode.campus_x_backend.university.domain.ports.output.SpecialtyRepositoryPort;
import com.joucode.campus_x_backend.university.domain.ports.output.UniversityRepositoryPort;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.SpecialtyPersistenceAdapter;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.UniversityPersistenceAdapter;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.mappers.UniversityMapper;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.respository.SpecialtyRepository;
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
    public SpecialtyPersistenceAdapter areasPersistenceAdapter(SpecialtyRepository repository, UniversityMapper mapper){
        return new SpecialtyPersistenceAdapter(repository, mapper);
    }

    @Bean
    public UniversityService universityService(UniversityRepositoryPort repositoryPort){
        return new UniversityService(
                new CreateUniversityUseCaseImpl(repositoryPort),
                new RetrieveUniversityUseCaseImpl(repositoryPort)
        );
    }

    @Bean
    public SpecialtyService areasService(SpecialtyRepositoryPort repositoryPort){
        return new SpecialtyService(
                new CreateSpecialtyUseCaseImpl(repositoryPort),
                new RetrieveSpecialtyUseCaseImpl(repositoryPort)
        );
    }
}
