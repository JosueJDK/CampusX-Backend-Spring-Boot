package com.joucode.campus_x_backend.province.infrastructure.output.persistence.repository;

import com.joucode.campus_x_backend.province.infrastructure.output.persistence.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {
}
