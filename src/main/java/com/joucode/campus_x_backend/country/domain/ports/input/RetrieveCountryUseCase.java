package com.joucode.campus_x_backend.country.domain.ports.input;

import com.joucode.campus_x_backend.country.domain.models.Country;

import java.util.List;

public interface RetrieveCountryUseCase {

    Country getById(Long id);

    List<Country> getAll();

}
