package com.joucode.campus_x_backend.address.domain.province.ports.output;

import com.joucode.campus_x_backend.address.domain.province.models.Province;

import java.util.List;
import java.util.Optional;

public interface ProvinceRepositporyPort {

    Province save(Province province);

    Optional<Province> getById(Long id);

    List<Province> getAll();

}
