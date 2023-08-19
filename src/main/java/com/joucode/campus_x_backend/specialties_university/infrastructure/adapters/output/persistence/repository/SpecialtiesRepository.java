package com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.output.persistence.repository;

import com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.output.persistence.entity.SpecialtiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtiesRepository extends JpaRepository<SpecialtiesEntity,Long> {
}
