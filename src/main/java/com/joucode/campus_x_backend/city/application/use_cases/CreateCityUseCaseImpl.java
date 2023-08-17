package com.joucode.campus_x_backend.city.application.use_cases;

import com.joucode.campus_x_backend.city.domain.models.City;
import com.joucode.campus_x_backend.city.domain.ports.input.CreateCityUseCase;
import com.joucode.campus_x_backend.city.domain.ports.output.CityRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCityUseCaseImpl implements CreateCityUseCase {

    private final CityRepositoryPort repositoryPort;

    @Override
    public City save(City city) {
        return repositoryPort.save(city);
    }
}
