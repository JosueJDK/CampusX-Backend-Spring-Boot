package com.joucode.campus_x_backend.address.application.city.use_cases;

import com.joucode.campus_x_backend.address.domain.city.models.City;
import com.joucode.campus_x_backend.address.domain.city.ports.input.CreateCityUseCase;
import com.joucode.campus_x_backend.address.domain.city.ports.output.CityRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCityUseCaseImpl implements CreateCityUseCase {

    private final CityRepositoryPort repositoryPort;

    @Override
    public City save(City city) {
        return repositoryPort.save(city);
    }
}
