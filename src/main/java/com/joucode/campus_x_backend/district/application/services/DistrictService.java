package com.joucode.campus_x_backend.district.application.services;

import com.joucode.campus_x_backend.district.domain.models.District;
import com.joucode.campus_x_backend.district.domain.ports.input.CreateDistrictUseCase;
import com.joucode.campus_x_backend.district.domain.ports.input.RetrieveDistrictUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DistrictService implements
        CreateDistrictUseCase,
        RetrieveDistrictUseCase {

    private final CreateDistrictUseCase createDistrict;

    private final RetrieveDistrictUseCase retrieveCountry;

    @Override
    public District save(District district) {
        return createDistrict.save(district);
    }

    @Override
    public District getById(Long id) {
        return retrieveCountry.getById(id);
    }

    @Override
    public List<District> getAll() {
        return retrieveCountry.getAll();
    }
}
