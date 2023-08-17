package com.joucode.campus_x_backend.address.domain.province.ports.input;

import com.joucode.campus_x_backend.address.domain.country.models.Country;
import com.joucode.campus_x_backend.address.domain.province.models.Province;

import java.util.List;

public interface RetrieveProvinceUseCase {

    Province getById(Long id);

    List<Province> getAll();
}
