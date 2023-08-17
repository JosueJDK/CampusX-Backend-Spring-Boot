package com.joucode.campus_x_backend.address.infrastructure.adapters.address.output.persistence.repository;

import com.joucode.campus_x_backend.address.infrastructure.adapters.address.output.persistence.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
