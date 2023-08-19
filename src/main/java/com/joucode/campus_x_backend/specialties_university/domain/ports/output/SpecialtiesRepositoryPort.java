package com.joucode.campus_x_backend.specialties_university.domain.ports.output;

import com.joucode.campus_x_backend.specialties_university.domain.models.Specialties;

import java.util.List;
import java.util.Optional;

public interface SpecialtiesRepositoryPort {

    Specialties save(Specialties specialties);

    Optional<Specialties> findById(Long id);


    List<Specialties> findAll();

}
