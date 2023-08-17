package com.joucode.campus_x_backend.district.domain.ports.input;

import com.joucode.campus_x_backend.district.domain.models.District;

import java.util.List;

public interface RetrieveDistrictUseCase {

    District getById(Long id);

    List<District> getAll();

}
