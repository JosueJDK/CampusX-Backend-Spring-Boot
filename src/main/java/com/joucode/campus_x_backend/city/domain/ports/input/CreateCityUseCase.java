package com.joucode.campus_x_backend.city.domain.ports.input;

import com.joucode.campus_x_backend.city.domain.models.City;

public interface CreateCityUseCase {

    City save(City city);

}
