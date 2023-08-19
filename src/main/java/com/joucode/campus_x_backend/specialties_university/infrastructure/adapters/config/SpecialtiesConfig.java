package com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.config;

import com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.output.persistence.SpecialtiesPersistenceAdapter;
import com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.output.persistence.mappers.SpecialtiesMapper;
import com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.output.persistence.repository.SpecialtiesRepository;
import com.joucode.campus_x_backend.specialties_university.application.services.SpecialtiesService;
import com.joucode.campus_x_backend.specialties_university.application.use_cases.CreateSpecialtiesUseCaseImpl;
import com.joucode.campus_x_backend.specialties_university.application.use_cases.RetrieveSpecialtiesUseCaseImpl;
import com.joucode.campus_x_backend.specialties_university.domain.ports.output.SpecialtiesRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpecialtiesConfig {

    @Bean
    public SpecialtiesMapper specialtiesMapper(){
        return new SpecialtiesMapper();
    }

    @Bean
    public SpecialtiesPersistenceAdapter areasPersistenceAdapter(SpecialtiesRepository repository, SpecialtiesMapper mapper){
        return new SpecialtiesPersistenceAdapter(repository, mapper);
    }

    @Bean
    public SpecialtiesService areasService(SpecialtiesRepositoryPort repositoryPort){
        return new SpecialtiesService(
                new CreateSpecialtiesUseCaseImpl(repositoryPort),
                new RetrieveSpecialtiesUseCaseImpl(repositoryPort)
        );
    }
}
