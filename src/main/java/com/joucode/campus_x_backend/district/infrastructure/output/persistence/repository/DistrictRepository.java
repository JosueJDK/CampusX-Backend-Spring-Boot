package com.joucode.campus_x_backend.district.infrastructure.output.persistence.repository;

import com.joucode.campus_x_backend.district.infrastructure.output.persistence.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {
}
