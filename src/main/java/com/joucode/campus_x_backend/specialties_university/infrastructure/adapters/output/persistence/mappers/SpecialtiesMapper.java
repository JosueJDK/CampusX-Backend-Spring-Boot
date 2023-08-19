package com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.output.persistence.mappers;

import com.joucode.campus_x_backend.specialties_university.domain.models.Specialties;
import com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.output.persistence.entity.SpecialtiesEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class SpecialtiesMapper {

    @Autowired
    private ModelMapper mapper;


    public SpecialtiesEntity toEntity(Specialties specialties){
        return mapper.map(specialties, SpecialtiesEntity.class);
    }

    public Specialties toModel(SpecialtiesEntity specialty){
        return mapper.map(specialty, Specialties.class);
    }

    public List<Specialties> toSpecialtyList(List<SpecialtiesEntity> specialty) {
        return specialty.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }


}
