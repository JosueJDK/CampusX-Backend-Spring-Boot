package com.joucode.campus_x_backend.country.application.use_cases;

import com.joucode.campus_x_backend.country.domain.models.Country;
import com.joucode.campus_x_backend.country.domain.ports.input.RetrieveCountryUseCase;
import com.joucode.campus_x_backend.country.domain.ports.output.CountryRepositoryPort;
import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import java.util.List;
@AllArgsConstructor
public class RetrieveCountryImpl implements RetrieveCountryUseCase {

    private final CountryRepositoryPort repositoryPort;

    @Override
    public Country getById(Long id) {
        return repositoryPort.getById(id).orElseThrow(
                () -> new NotFoundException("El pais no existe")
        );
    }

    @Override
    public List<Country> getAll() {
        return repositoryPort.getAll();
    }
}
