package com.joucode.campus_x_backend.address.infrastructure.adapters.district.output.persistence;

import com.joucode.campus_x_backend.address.domain.district.models.District;
import com.joucode.campus_x_backend.address.domain.district.ports.output.DistrictRepositoryPort;
import com.joucode.campus_x_backend.address.infrastructure.adapters.district.output.persistence.entity.DistrictEntity;
import com.joucode.campus_x_backend.address.infrastructure.adapters.district.output.persistence.mappers.DistrictMapper;
import com.joucode.campus_x_backend.address.infrastructure.adapters.district.output.persistence.repository.DistrictRepository;
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
        return mapper.toList(repository.findAll());
    }
}