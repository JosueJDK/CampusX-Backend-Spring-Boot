package com.joucode.campus_x_backend.university.domain.ports.output;

import com.joucode.campus_x_backend.university.domain.models.Specialty;

import java.util.List;
import java.util.Optional;

public interface SpecialtyRepositoryPort {

    Specialty save(Specialty specialty);

    Optional<Specialty> findById(Long id);


    List<Specialty> findAll();

}
