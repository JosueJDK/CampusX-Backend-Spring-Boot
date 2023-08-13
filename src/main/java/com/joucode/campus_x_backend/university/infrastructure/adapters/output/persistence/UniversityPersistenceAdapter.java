package com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence;

import com.joucode.campus_x_backend.university.domain.models.University;
import com.joucode.campus_x_backend.university.domain.ports.output.UniversityRepositoryPort;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.entity.UniversityEntity;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.mappers.UniversityMapper;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.respository.UniversityRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UniversityPersistenceAdapter implements UniversityRepositoryPort {

    private final UniversityRepository repository;

    private final UniversityMapper mapper;

    @Override
    public University save(University university) {
        return mapper.toModel(repository.save(mapper.toEntity(university)));
    }

    @Override
    public Optional<University> findById(Long id) {
        Optional<UniversityEntity> university = repository.findById(id);
        return university.map(mapper::toModel);
    }

    @Override
    public List<University> findAll() {
        List<UniversityEntity> universities = repository.findAll();
        return mapper.toUniversityList(universities);
    }
}
