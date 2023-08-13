package com.joucode.campus_x_backend.address.infrastructure.adapters.country.config;

import com.joucode.campus_x_backend.address.application.country.services.CountryService;
import com.joucode.campus_x_backend.address.application.country.use_cases.CreateCountryImpl;
import com.joucode.campus_x_backend.address.application.country.use_cases.RetrieveCountryImpl;
import com.joucode.campus_x_backend.address.domain.country.ports.output.CountryRepositoryPort;
import com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence.CountryPersistenceAdapter;
import com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence.mappers.CountryMapper;
import com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence.repository.CountryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryConfig {

    @Bean
    public CountryMapper countryMapper(){
        return new CountryMapper();
    }

    @Bean
    public CountryPersistenceAdapter countryPersistenceAdapter(CountryRepository repository, CountryMapper mapper){
        return new CountryPersistenceAdapter(
                repository,
                mapper
        );
    }

    @Bean
    public CountryService countryService(CountryRepositoryPort repositoryPort){
        return new CountryService(
                new CreateCountryImpl(repositoryPort),
                new RetrieveCountryImpl(repositoryPort)
        );
    }

}
