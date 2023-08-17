package com.joucode.campus_x_backend.country.application.use_cases;

import com.joucode.campus_x_backend.country.domain.models.Country;
import com.joucode.campus_x_backend.country.domain.ports.input.CreateCountryUseCase;
import com.joucode.campus_x_backend.country.domain.ports.output.CountryRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCountryImpl implements CreateCountryUseCase {

    private final CountryRepositoryPort repositoryPort;

    @Override
    public Country save(Country country) {
        return repositoryPort.save(country);
    }
}
