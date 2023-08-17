package com.joucode.campus_x_backend.city.application.use_cases;

import com.joucode.campus_x_backend.city.domain.models.City;
import com.joucode.campus_x_backend.city.domain.ports.input.RetrieveCityUseCase;
import com.joucode.campus_x_backend.city.domain.ports.output.CityRepositoryPort;
import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class RetrieveCityUsecaseImpl implements RetrieveCityUseCase {

    private final CityRepositoryPort repositoryPort;

    @Override
    public City getById(Long id) {
        return repositoryPort.findById(id).orElseThrow(
                () -> new NotFoundException("El pais no existe")
        );
    }

    @Override
    public List<City> getAll() {
        return repositoryPort.getAll();
    }
}
