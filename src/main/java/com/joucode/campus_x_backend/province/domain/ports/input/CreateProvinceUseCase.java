package com.joucode.campus_x_backend.province.domain.ports.input;

import com.joucode.campus_x_backend.province.domain.models.Province;

public interface CreateProvinceUseCase {

    Province save(Province province);

}
