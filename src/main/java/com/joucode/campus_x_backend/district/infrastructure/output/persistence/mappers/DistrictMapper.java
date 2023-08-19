package com.joucode.campus_x_backend.district.infrastructure.output.persistence.mappers;

import com.joucode.campus_x_backend.city.domain.models.City;
import com.joucode.campus_x_backend.district.domain.models.District;
import com.joucode.campus_x_backend.district.infrastructure.output.persistence.entity.DistrictEntity;
import com.joucode.campus_x_backend.province.domain.models.Province;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class DistrictMapper {

    @Autowired
    private ModelMapper mapper;

    public DistrictEntity toEntity(District district){
        return mapper.map(district, DistrictEntity.class);
    }

    public District toModel(DistrictEntity district){
        return mapper.map(district, District.class);
    }

    public List<District> toList(List<DistrictEntity> district) {
        return district.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
