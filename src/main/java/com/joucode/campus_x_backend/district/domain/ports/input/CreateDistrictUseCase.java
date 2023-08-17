package com.joucode.campus_x_backend.district.domain.ports.input;

import com.joucode.campus_x_backend.district.domain.models.District;

public interface CreateDistrictUseCase {

    District save(District district);
}
