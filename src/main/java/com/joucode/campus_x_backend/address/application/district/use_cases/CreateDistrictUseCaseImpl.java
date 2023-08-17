package com.joucode.campus_x_backend.address.application.district.use_cases;

import com.joucode.campus_x_backend.address.domain.district.models.District;
import com.joucode.campus_x_backend.address.domain.district.ports.input.CreateDistrictUseCase;
import com.joucode.campus_x_backend.address.domain.district.ports.output.DistrictRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateDistrictUseCaseImpl implements CreateDistrictUseCase {

    private final DistrictRepositoryPort repositoryPort;

    @Override
    public District save(District district) {
        return repositoryPort.save(district);
    }
}
