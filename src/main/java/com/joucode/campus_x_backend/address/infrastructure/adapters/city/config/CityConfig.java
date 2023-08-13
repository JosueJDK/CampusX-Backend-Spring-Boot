package com.joucode.campus_x_backend.address.infrastructure.adapters.city.config;

import com.joucode.campus_x_backend.address.application.city.services.CityService;
import com.joucode.campus_x_backend.address.application.city.use_cases.CreateCityUseCaseImpl;
import com.joucode.campus_x_backend.address.application.city.use_cases.RetrieveCityUsecaseImpl;
import com.joucode.campus_x_backend.address.domain.city.ports.output.CityRepositoryPort;
import com.joucode.campus_x_backend.address.infrastructure.adapters.city.output.persistence.CityPersistenceAdapter;
import com.joucode.campus_x_backend.address.infrastructure.adapters.city.output.persistence.mappers.CityMapper;
import com.joucode.campus_x_backend.address.infrastructure.adapters.city.output.persistence.repository.CityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CityConfig {

    @Bean
    public CityMapper cityMapper(){
        return new CityMapper();
    }

    @Bean
    public CityPersistenceAdapter cityPersistenceAdapter(CityRepository repository, CityMapper mapper){
        return new CityPersistenceAdapter(
          repository,
          mapper
        );
    }

    @Bean
    public CityService cityService(CityRepositoryPort repositoryPort){
        return new CityService(
                new CreateCityUseCaseImpl(repositoryPort),
                new RetrieveCityUsecaseImpl(repositoryPort)
        );
    }

}
