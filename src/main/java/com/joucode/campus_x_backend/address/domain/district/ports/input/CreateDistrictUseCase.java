package com.joucode.campus_x_backend.address.domain.district.ports.input;

import com.joucode.campus_x_backend.address.domain.district.models.District;

public interface CreateDistrictUseCase {

    District save(District district);
}
