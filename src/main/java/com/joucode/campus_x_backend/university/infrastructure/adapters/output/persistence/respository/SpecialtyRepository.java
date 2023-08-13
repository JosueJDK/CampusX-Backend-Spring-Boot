package com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.respository;

import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.entity.SpecialtyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<SpecialtyEntity,Long> {
}
