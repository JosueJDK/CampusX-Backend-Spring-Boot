package com.joucode.campus_x_backend.city.infrastructure.output.persistence;

import com.joucode.campus_x_backend.city.domain.models.City;
import com.joucode.campus_x_backend.city.domain.ports.output.CityRepositoryPort;
import com.joucode.campus_x_backend.city.infrastructure.output.persistence.entity.CityEntity;
import com.joucode.campus_x_backend.city.infrastructure.output.persistence.mappers.CityMapper;
import com.joucode.campus_x_backend.city.infrastructure.output.persistence.repository.CityRepository;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CityPersistenceAdapter implements CityRepositoryPort {

    private final CityRepository repository;

    private final CityMapper mapper;

    @Override
    public City save(City city) {
        return mapper.toModel(repository.save(mapper.toEntity(city)));
    }

    @Override
    public Optional<City> findById(Long id) {
        Optional<CityEntity> city = repository.findById(id);
        return city.map(mapper::toModel);
    }

    @Override
    public List<City> getAll() {
        return mapper.toList(repository.findAll());
    }
}
