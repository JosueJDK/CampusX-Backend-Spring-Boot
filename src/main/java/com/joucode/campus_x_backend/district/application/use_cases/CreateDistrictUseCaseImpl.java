package com.joucode.campus_x_backend.district.application.use_cases;

import com.joucode.campus_x_backend.district.domain.models.District;
import com.joucode.campus_x_backend.district.domain.ports.input.CreateDistrictUseCase;
import com.joucode.campus_x_backend.district.domain.ports.output.DistrictRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateDistrictUseCaseImpl implements CreateDistrictUseCase {

    private final DistrictRepositoryPort repositoryPort;

    @Override
    public District save(District district) {
        return repositoryPort.save(district);
    }
}
