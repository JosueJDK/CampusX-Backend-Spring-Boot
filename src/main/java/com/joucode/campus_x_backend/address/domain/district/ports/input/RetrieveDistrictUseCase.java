package com.joucode.campus_x_backend.address.domain.district.ports.input;

import com.joucode.campus_x_backend.address.domain.district.models.District;

import java.util.List;

public interface RetrieveDistrictUseCase {

    District getById(Long id);

    List<District> getAll();

}
