package com.joucode.campus_x_backend.address.application.city.services;

import com.joucode.campus_x_backend.address.domain.city.models.City;
import com.joucode.campus_x_backend.address.domain.city.ports.input.CreateCityUseCase;
import com.joucode.campus_x_backend.address.domain.city.ports.input.RetrieveCityUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityService implements
        CreateCityUseCase,
        RetrieveCityUseCase {

    private final  CreateCityUseCase createCity;

    private final RetrieveCityUseCase retrieveCity;

    @Override
    public City save(City city) {
        return createCity.save(city);
    }

    @Override
    public City getById(Long id) {
        return retrieveCity.getById(id);
    }

    @Override
    public List<City> getAll() {
        return retrieveCity.getAll();
    }
}
