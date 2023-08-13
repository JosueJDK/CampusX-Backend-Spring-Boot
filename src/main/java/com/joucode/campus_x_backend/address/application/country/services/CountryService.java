package com.joucode.campus_x_backend.address.application.country.services;

import com.joucode.campus_x_backend.address.domain.country.models.Country;
import com.joucode.campus_x_backend.address.domain.country.ports.input.CreateCountryUseCase;
import com.joucode.campus_x_backend.address.domain.country.ports.input.RetrieveCountryUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CountryService implements
        CreateCountryUseCase,
        RetrieveCountryUseCase {

    private final CreateCountryUseCase createCountry;

    private final RetrieveCountryUseCase retrieveCountry;

    @Override
    public Country save(Country country) {
        return createCountry.save(country);
    }

    @Override
    public Country getById(Long id) {
        return retrieveCountry.getById(id);
    }

    @Override
    public List<Country> getAll() {
        return retrieveCountry.getAll();
    }
}
