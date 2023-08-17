package com.joucode.campus_x_backend.province.infrastructure.config;

import com.joucode.campus_x_backend.province.application.services.ProvinceService;
import com.joucode.campus_x_backend.province.application.use_cases.CreateProvinceUseCaseImpl;
import com.joucode.campus_x_backend.province.application.use_cases.RetrieveProvinceUseCaseImpl;
import com.joucode.campus_x_backend.province.domain.ports.output.ProvinceRepositporyPort;
import com.joucode.campus_x_backend.province.infrastructure.output.persistence.ProvincePersistenceAdapter;
import com.joucode.campus_x_backend.province.infrastructure.output.persistence.mappers.ProvinceMapper;
import com.joucode.campus_x_backend.province.infrastructure.output.persistence.repository.ProvinceRepository;
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
