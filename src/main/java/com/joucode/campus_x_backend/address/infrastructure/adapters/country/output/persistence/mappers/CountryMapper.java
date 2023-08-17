package com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence.mappers;

import com.joucode.campus_x_backend.address.domain.country.models.Country;
import com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence.entity.CountryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CountryMapper {

    @Autowired
    private ModelMapper mapper;

    public CountryEntity toEntity(Country country){
        return mapper.map(country, CountryEntity.class);
    }

    public Country toModel(CountryEntity country){
        return mapper.map(country, Country.class);
    }

    public List<Country> toList(List<CountryEntity> country) {
        return country.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }


}
