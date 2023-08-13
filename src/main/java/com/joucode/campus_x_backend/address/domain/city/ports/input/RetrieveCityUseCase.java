package com.joucode.campus_x_backend.address.domain.city.ports.input;

import com.joucode.campus_x_backend.address.domain.city.models.City;

import java.util.List;

public interface RetrieveCityUseCase {

    City getById(Long id);

    List<City> getAll();

}
