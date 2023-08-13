package com.joucode.campus_x_backend.address.domain.country.ports.input;

import com.joucode.campus_x_backend.address.domain.country.models.Country;

public interface CreateCountryUseCase {

    Country save(Country country);

}
