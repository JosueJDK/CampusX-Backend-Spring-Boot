package com.joucode.campus_x_backend.country.domain.ports.input;

import com.joucode.campus_x_backend.country.domain.models.Country;

public interface CreateCountryUseCase {

    Country save(Country country);

}
