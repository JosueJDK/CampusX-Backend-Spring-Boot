package com.joucode.campus_x_backend.district.infrastructure.output.persistence;

import com.joucode.campus_x_backend.district.domain.models.District;
import com.joucode.campus_x_backend.district.domain.ports.output.DistrictRepositoryPort;
import com.joucode.campus_x_backend.district.infrastructure.output.persistence.entity.DistrictEntity;
import com.joucode.campus_x_backend.district.infrastructure.output.persistence.repository.DistrictRepository;
import com.joucode.campus_x_backend.district.infrastructure.output.persistence.mappers.DistrictMapper;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class DistrictPersistenceAdapter implements DistrictRepositoryPort {

    private final DistrictRepository repository;

    private final DistrictMapper mapper;

    @Override
    public District save(District district) {
        return mapper.toModel(repository.save(mapper.toEntity(district)));
    }

    @Override
    public Optional<District> getById(Long id) {
        Optional<DistrictEntity> district = repository.findById(id);
        return district.map(mapper::toModel);
    }

    @Override
    public List<District> getAll() {
        System.out.println(repository.findAll().get(0).getCity());
        return mapper.toList(repository.findAll());
    }
}