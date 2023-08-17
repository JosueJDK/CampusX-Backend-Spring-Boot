package com.joucode.campus_x_backend.province.infrastructure.output.persistence;

import com.joucode.campus_x_backend.province.domain.models.Province;
import com.joucode.campus_x_backend.province.domain.ports.output.ProvinceRepositporyPort;
import com.joucode.campus_x_backend.province.infrastructure.output.persistence.entity.ProvinceEntity;
import com.joucode.campus_x_backend.province.infrastructure.output.persistence.mappers.ProvinceMapper;
import com.joucode.campus_x_backend.province.infrastructure.output.persistence.repository.ProvinceRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProvincePersistenceAdapter implements ProvinceRepositporyPort {

    private final ProvinceRepository repository;

    private final ProvinceMapper mapper;

    @Override
    public Province save(Province province) {
        return mapper.toModel(repository.save(mapper.toEntity(province)));
    }

    @Override
    public Optional<Province> getById(Long id) {
        Optional<ProvinceEntity> province = repository.findById(id);
        return province.map(mapper::toModel);
    }

    @Override
    public List<Province> getAll() {
        return mapper.toList(repository.findAll());
    }
}
