package com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence;

import com.joucode.campus_x_backend.university.domain.models.Specialty;
import com.joucode.campus_x_backend.university.domain.ports.output.SpecialtyRepositoryPort;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.entity.SpecialtyEntity;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.mappers.UniversityMapper;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.respository.SpecialtyRepository;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class SpecialtyPersistenceAdapter implements SpecialtyRepositoryPort {

    private final SpecialtyRepository areaUniversityRepository;

    private final UniversityMapper mapper;

    @Override
    public Specialty save(Specialty area) {
        return mapper.toModel(areaUniversityRepository.save(mapper.toEntity(area)));
    }

    @Override
    public Optional<Specialty> findById(Long id) {
        Optional<SpecialtyEntity> area = areaUniversityRepository.findById(id);
        return area.map(mapper::toModel);
    }

    @Override
    public List<Specialty> findAll() {
        List<SpecialtyEntity> areas = areaUniversityRepository.findAll();
        return mapper.toSpecialtyList(areas);
    }
}
