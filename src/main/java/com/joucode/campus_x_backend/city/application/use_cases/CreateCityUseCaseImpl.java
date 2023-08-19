package com.joucode.campus_x_backend.city.application.use_cases;

import com.joucode.campus_x_backend.city.domain.models.City;
import com.joucode.campus_x_backend.city.domain.ports.input.CreateCityUseCase;
import com.joucode.campus_x_backend.city.domain.ports.output.CityRepositoryPort;
import com.joucode.campus_x_backend.country.application.services.CountryService;
import com.joucode.campus_x_backend.country.domain.models.Country;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCityUseCaseImpl implements CreateCityUseCase {

    private final CityRepositoryPort repositoryPort;
    private final CountryService countryService;

    @Override
    public City save(City city) {
        Country country = countryService.getById(city.getCountry().getCountryId());
        city.setCountry(country);
        return repositoryPort.save(city);
    }
}
