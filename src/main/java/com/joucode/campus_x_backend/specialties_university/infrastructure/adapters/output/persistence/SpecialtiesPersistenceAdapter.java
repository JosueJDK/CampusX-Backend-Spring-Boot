package com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.output.persistence;

import com.joucode.campus_x_backend.specialties_university.domain.models.Specialties;
import com.joucode.campus_x_backend.specialties_university.domain.ports.output.SpecialtiesRepositoryPort;
import com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.output.persistence.entity.SpecialtiesEntity;
import com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.output.persistence.mappers.SpecialtiesMapper;
import com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.output.persistence.repository.SpecialtiesRepository;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class SpecialtiesPersistenceAdapter implements SpecialtiesRepositoryPort {

    private final SpecialtiesRepository areaUniversityRepository;

    private final SpecialtiesMapper mapper;

    @Override
    public Specialties save(Specialties area) {
        return mapper.toModel(areaUniversityRepository.save(mapper.toEntity(area)));
    }

    @Override
    public Optional<Specialties> findById(Long id) {
        Optional<SpecialtiesEntity> area = areaUniversityRepository.findById(id);
        return area.map(mapper::toModel);
    }

    @Override
    public List<Specialties> findAll() {
        List<SpecialtiesEntity> areas = areaUniversityRepository.findAll();
        return mapper.toSpecialtyList(areas);
    }
}
