package com.joucode.campus_x_backend.province.domain.ports.input;

import com.joucode.campus_x_backend.province.domain.models.Province;

import java.util.List;

public interface RetrieveProvinceUseCase {

    Province getById(Long id);

    List<Province> getAll();
}
