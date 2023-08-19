package com.joucode.campus_x_backend.city.application.services;

import com.joucode.campus_x_backend.city.domain.models.City;
import com.joucode.campus_x_backend.city.domain.ports.input.CreateCityUseCase;
import com.joucode.campus_x_backend.city.domain.ports.input.RetrieveCityUseCase;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Transactional
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
