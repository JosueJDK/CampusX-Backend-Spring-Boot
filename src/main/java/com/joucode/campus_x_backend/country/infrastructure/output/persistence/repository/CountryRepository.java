package com.joucode.campus_x_backend.country.infrastructure.output.persistence.repository;

import com.joucode.campus_x_backend.country.infrastructure.output.persistence.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
