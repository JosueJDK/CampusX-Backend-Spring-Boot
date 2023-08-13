package com.joucode.campus_x_backend.address.domain.city.ports.input;

import com.joucode.campus_x_backend.address.domain.city.models.City;

public interface CreateCityUseCase {

    City save(City city);

}
