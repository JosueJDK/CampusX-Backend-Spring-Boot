package com.joucode.campus_x_backend.city.domain.ports.output;

import com.joucode.campus_x_backend.city.domain.models.City;

import java.util.List;
import java.util.Optional;

public interface CityRepositoryPort {

    City save(City city);

    Optional<City> findById(Long id);

    List<City> getAll();

}
