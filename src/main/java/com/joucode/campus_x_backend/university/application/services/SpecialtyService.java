package com.joucode.campus_x_backend.university.application.services;

import com.joucode.campus_x_backend.university.domain.models.Specialty;
import com.joucode.campus_x_backend.university.domain.ports.input.specialty.CreateSpecialtyUseCase;
import com.joucode.campus_x_backend.university.domain.ports.input.specialty.RetrieveSpecialtyUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SpecialtyService implements
        CreateSpecialtyUseCase,
        RetrieveSpecialtyUseCase {

    private final CreateSpecialtyUseCase createSpecialty;

    private final RetrieveSpecialtyUseCase retrieveSpecialty;

    @Override
    public Specialty save(Specialty specialty) {
        return createSpecialty.save(specialty);
    }

    @Override
    public Specialty getById(Long id) {
        return retrieveSpecialty.getById(id);
    }

    @Override
    public List<Specialty> getAll() {
        return retrieveSpecialty.getAll();
    }

}
