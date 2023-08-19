package com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.mappers;

import com.joucode.campus_x_backend.university.domain.models.University;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.entity.UniversityEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UniversityMapper {

    @Autowired
    private ModelMapper mapper;

    public UniversityEntity toEntity(University university){
        return mapper.map(university, UniversityEntity.class);
    }

    public University toModel(UniversityEntity university){
        return mapper.map(university, University.class);
    }

    public List<University> toUniversityList(List<UniversityEntity> universities) {
        return universities.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
