package com.joucode.campus_x_backend.city.domain.ports.input;

import com.joucode.campus_x_backend.city.domain.models.City;

import java.util.List;

public interface RetrieveCityUseCase {

    City getById(Long id);

    List<City> getAll();

}
