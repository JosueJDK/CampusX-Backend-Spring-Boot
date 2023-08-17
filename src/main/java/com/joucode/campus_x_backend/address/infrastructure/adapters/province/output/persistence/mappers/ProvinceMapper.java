package com.joucode.campus_x_backend.address.infrastructure.adapters.province.output.persistence.mappers;

import com.joucode.campus_x_backend.address.domain.province.models.Province;
import com.joucode.campus_x_backend.address.infrastructure.adapters.province.output.persistence.entity.ProvinceEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

public class ProvinceMapper {

    @Autowired
    private ModelMapper mapper;

    public ProvinceEntity toEntity(Province province){
        return mapper.map(province, ProvinceEntity.class);
    }

    public Province toModel(ProvinceEntity province){
        return mapper.map(province, Province.class);
    }

    public List<Province> toList(List<ProvinceEntity> province) {
        return province.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }


}
