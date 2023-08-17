package com.joucode.campus_x_backend.address.infrastructure.adapters.district.output.persistence.repository;

import com.joucode.campus_x_backend.address.infrastructure.adapters.district.output.persistence.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {
}
