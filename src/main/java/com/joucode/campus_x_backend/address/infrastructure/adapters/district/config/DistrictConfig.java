package com.joucode.campus_x_backend.address.infrastructure.adapters.district.config;

import com.joucode.campus_x_backend.address.application.district.services.DistrictService;
import com.joucode.campus_x_backend.address.application.district.use_cases.CreateDistrictUseCaseImpl;
import com.joucode.campus_x_backend.address.application.district.use_cases.RetrieveDistrictUseCaseImpl;
import com.joucode.campus_x_backend.address.domain.district.ports.output.DistrictRepositoryPort;
import com.joucode.campus_x_backend.address.infrastructure.adapters.district.output.persistence.DistrictPersistenceAdapter;
import com.joucode.campus_x_backend.address.infrastructure.adapters.district.output.persistence.mappers.DistrictMapper;
import com.joucode.campus_x_backend.address.infrastructure.adapters.district.output.persistence.repository.DistrictRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DistrictConfig {

    @Bean
    public DistrictMapper districtMapper(){
        return new DistrictMapper();
    }

    @Bean
    public DistrictPersistenceAdapter districtPersistenceAdapter(DistrictRepository repository, DistrictMapper mapper){
        return new DistrictPersistenceAdapter(
                repository,
                mapper
        );
    }

    @Bean
    public DistrictService districtService(DistrictRepositoryPort repositoryPort){
        return new DistrictService(
                new CreateDistrictUseCaseImpl(repositoryPort),
                new RetrieveDistrictUseCaseImpl(repositoryPort)
        );
    }

}
