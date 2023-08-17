package com.joucode.campus_x_backend.address.infrastructure.adapters.province.output.persistence.repository;

import com.joucode.campus_x_backend.address.infrastructure.adapters.province.output.persistence.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {
}
