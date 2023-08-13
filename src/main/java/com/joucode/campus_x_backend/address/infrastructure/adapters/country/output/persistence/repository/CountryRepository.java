package com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence.repository;

import com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
