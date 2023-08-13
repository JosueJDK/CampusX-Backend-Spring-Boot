package com.joucode.campus_x_backend.address.domain.country.ports.output;

import com.joucode.campus_x_backend.address.domain.country.models.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepositoryPort {

    Country save(Country country);

    Optional<Country> getById(Long id);

    List<Country> getAll();

}
