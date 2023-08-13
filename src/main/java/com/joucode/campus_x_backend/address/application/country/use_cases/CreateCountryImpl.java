package com.joucode.campus_x_backend.address.application.country.use_cases;

import com.joucode.campus_x_backend.address.domain.country.models.Country;
import com.joucode.campus_x_backend.address.domain.country.ports.input.CreateCountryUseCase;
import com.joucode.campus_x_backend.address.domain.country.ports.output.CountryRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCountryImpl implements CreateCountryUseCase {

    private final CountryRepositoryPort repositoryPort;

    @Override
    public Country save(Country country) {
        return repositoryPort.save(country);
    }
}
