package com.joucode.campus_x_backend.city.infrastructure.output.persistence.repository;

import com.joucode.campus_x_backend.city.infrastructure.output.persistence.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

}
