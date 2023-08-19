package com.joucode.campus_x_backend.address.infrastructure.adapters.config;

import com.joucode.campus_x_backend.address.application.services.AddressService;
import com.joucode.campus_x_backend.address.application.use_cases.CreateAddressUserProfileUseCaseImpl;
import com.joucode.campus_x_backend.address.application.use_cases.RetrieveAddressUseCaseImpl;
import com.joucode.campus_x_backend.address.domain.ports.output.AddressRepositoryPort;
import com.joucode.campus_x_backend.address.infrastructure.adapters.output.persistence.AddressPersistenceAdapter;
import com.joucode.campus_x_backend.address.infrastructure.adapters.output.persistence.mappers.AddressMapper;
import com.joucode.campus_x_backend.address.infrastructure.adapters.output.persistence.repository.AddressRepository;
import com.joucode.campus_x_backend.city.application.services.CityService;
import com.joucode.campus_x_backend.country.application.services.CountryService;
import com.joucode.campus_x_backend.district.application.services.DistrictService;
import com.joucode.campus_x_backend.province.application.services.ProvinceService;
import com.joucode.campus_x_backend.user_profile.application.service.UserProfileService;
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
    public AddressService addressService(
            AddressRepositoryPort repositoryPort,
            UserProfileService userProfileService,
            CountryService countryService,
            CityService cityService,
            ProvinceService provinceService,
            DistrictService districtService
    ){
        return new AddressService(
          new CreateAddressUserProfileUseCaseImpl(
                  repositoryPort,
                  userProfileService,
                  countryService,
                  cityService,
                  provinceService,
                  districtService
          ),
          new RetrieveAddressUseCaseImpl(repositoryPort)
        );

    }


}
