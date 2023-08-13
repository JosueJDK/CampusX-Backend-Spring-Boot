package com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence;

import com.joucode.campus_x_backend.address.domain.country.models.Country;
import com.joucode.campus_x_backend.address.domain.country.ports.output.CountryRepositoryPort;
import com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence.entity.CountryEntity;
import com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence.mappers.CountryMapper;
import com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence.repository.CountryRepository;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CountryPersistenceAdapter implements CountryRepositoryPort {

    private final CountryRepository repository;

    private final CountryMapper mapper;

    @Override
    public Country save(Country country) {
        return mapper.toModel(repository.save(mapper.toEntity(country)));
    }

    @Override
    public Optional<Country> getById(Long id) {
        Optional<CountryEntity> country = repository.findById(id);
        return country.map(mapper::toModel);
    }

    @Override
    public List<Country> getAll() {
        return mapper.toList(repository.findAll());
    }
}
