package com.joucode.campus_x_backend.address.domain.country.ports.input;

import com.joucode.campus_x_backend.address.domain.country.models.Country;
import java.util.List;

public interface RetrieveCountryUseCase {

    Country getById(Long id);

    List<Country> getAll();

}
