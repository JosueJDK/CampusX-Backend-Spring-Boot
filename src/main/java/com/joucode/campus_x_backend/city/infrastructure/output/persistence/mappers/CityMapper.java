package com.joucode.campus_x_backend.city.infrastructure.output.persistence.mappers;

import com.joucode.campus_x_backend.city.domain.models.City;
import com.joucode.campus_x_backend.city.infrastructure.output.persistence.entity.CityEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

public class CityMapper {

    @Autowired
    private ModelMapper mapper;

    public CityEntity toEntity(City city){
        return mapper.map(city, CityEntity.class);
    }

    public City toModel(CityEntity city){
        return mapper.map(city, City.class);
    }

    public List<City> toList(List<CityEntity> city) {
        return city.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
