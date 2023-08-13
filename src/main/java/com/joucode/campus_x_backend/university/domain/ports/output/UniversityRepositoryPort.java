package com.joucode.campus_x_backend.university.domain.ports.output;

import com.joucode.campus_x_backend.university.domain.models.University;

import java.util.List;
import java.util.Optional;

public interface UniversityRepositoryPort {

    University save(University university);

    Optional<University> findById(Long id);


    List<University> findAll();

}
