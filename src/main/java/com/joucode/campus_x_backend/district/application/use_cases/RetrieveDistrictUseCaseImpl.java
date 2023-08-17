package com.joucode.campus_x_backend.district.application.use_cases;

import com.joucode.campus_x_backend.district.domain.models.District;
import com.joucode.campus_x_backend.district.domain.ports.input.RetrieveDistrictUseCase;
import com.joucode.campus_x_backend.district.domain.ports.output.DistrictRepositoryPort;
import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveDistrictUseCaseImpl implements RetrieveDistrictUseCase {

    private final DistrictRepositoryPort repositoryPort;

    @Override
    public District getById(Long id) {
        return repositoryPort.getById(id).orElseThrow(
                () -> new NotFoundException("El distrito no existe")
        );
    }

    @Override
    public List<District> getAll() {
        return repositoryPort.getAll();
    }
}
