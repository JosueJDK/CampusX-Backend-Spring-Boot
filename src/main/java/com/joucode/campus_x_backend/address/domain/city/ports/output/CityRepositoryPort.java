package com.joucode.campus_x_backend.address.domain.city.ports.output;

import com.joucode.campus_x_backend.address.domain.city.models.City;

import java.util.List;
import java.util.Optional;

public interface CityRepositoryPort {

    City save(City city);

    Optional<City> findById(Long id);

    List<City> getAll();

}
