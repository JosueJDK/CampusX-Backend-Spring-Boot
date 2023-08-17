package com.joucode.campus_x_backend.address.infrastructure.adapters.address.config;

import com.joucode.campus_x_backend.address.application.adress.services.AddressService;
import com.joucode.campus_x_backend.address.application.adress.use_cases.CreateAddressUseCaseImpl;
import com.joucode.campus_x_backend.address.application.adress.use_cases.RetrieveAddressUseCaseImpl;
import com.joucode.campus_x_backend.address.domain.address.ports.output.AddressRepositoryPort;
import com.joucode.campus_x_backend.address.infrastructure.adapters.address.output.persistence.AddressPersistenceAdapter;
import com.joucode.campus_x_backend.address.infrastructure.adapters.address.output.persistence.mappers.AddressMapper;
import com.joucode.campus_x_backend.address.infrastructure.adapters.address.output.persistence.repository.AddressRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfig {

    @Bean
    public AddressMapper addressMapper(){
        return new AddressMapper();
    }

    @Bean
    public AddressPersistenceAdapter addressPersistenceAdapter(AddressRepository repository, AddressMapper mapper){
        return new AddressPersistenceAdapter(
                repository,
                mapper
        );
    }

    @Bean
    public AddressService addressService(AddressRepositoryPort repositoryPort){
        return new AddressService(
          new CreateAddressUseCaseImpl(repositoryPort),
          new RetrieveAddressUseCaseImpl(repositoryPort)
        );

    }


}
