package com.joucode.campus_x_backend.address.domain.district.ports.output;

import com.joucode.campus_x_backend.address.domain.district.models.District;
import java.util.List;
import java.util.Optional;

public interface DistrictRepositoryPort {

    District save(District district);

    Optional<District> getById(Long id);

    List<District> getAll();

}
