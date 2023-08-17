package com.joucode.campus_x_backend.district.domain.ports.output;

import com.joucode.campus_x_backend.district.domain.models.District;
import java.util.List;
import java.util.Optional;

public interface DistrictRepositoryPort {

    District save(District district);

    Optional<District> getById(Long id);

    List<District> getAll();

}
