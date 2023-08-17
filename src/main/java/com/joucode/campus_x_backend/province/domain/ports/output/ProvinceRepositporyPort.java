package com.joucode.campus_x_backend.province.domain.ports.output;

import com.joucode.campus_x_backend.province.domain.models.Province;

import java.util.List;
import java.util.Optional;

public interface ProvinceRepositporyPort {

    Province save(Province province);

    Optional<Province> getById(Long id);

    List<Province> getAll();

}
