package com.joucode.campus_x_backend.address.domain.province.ports.input;

import com.joucode.campus_x_backend.address.domain.province.models.Province;

public interface CreateProvinceUseCase {

    Province save(Province province);

}
