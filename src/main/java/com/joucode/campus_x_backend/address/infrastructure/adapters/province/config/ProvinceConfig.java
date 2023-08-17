package com.joucode.campus_x_backend.address.infrastructure.adapters.province.config;

import com.joucode.campus_x_backend.address.application.province.services.ProvinceService;
import com.joucode.campus_x_backend.address.application.province.use_cases.CreateProvinceUseCaseImpl;
import com.joucode.campus_x_backend.address.application.province.use_cases.RetrieveProvinceUseCaseImpl;
import com.joucode.campus_x_backend.address.domain.province.ports.output.ProvinceRepositporyPort;
import com.joucode.campus_x_backend.address.infrastructure.adapters.province.output.persistence.ProvincePersistenceAdapter;
import com.joucode.campus_x_backend.address.infrastructure.adapters.province.output.persistence.mappers.ProvinceMapper;
import com.joucode.campus_x_backend.address.infrastructure.adapters.province.output.persistence.repository.ProvinceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProvinceConfig {

    @Bean
    public ProvinceMapper provinceMapper(){
        return new ProvinceMapper();
    }

    @Bean
    public ProvincePersistenceAdapter provincePersistenceAdapter(ProvinceRepository repository, ProvinceMapper mapper){
        return new ProvincePersistenceAdapter(
                repository,
                mapper
        );
    }

    @Bean
    public ProvinceService provinceService(ProvinceRepositporyPort repositporyPort){
        return new ProvinceService(
                new CreateProvinceUseCaseImpl(repositporyPort),
                new RetrieveProvinceUseCaseImpl(repositporyPort)
        );
    }


}
