package com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.respository;

import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.entity.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<UniversityEntity, Long> {
}
