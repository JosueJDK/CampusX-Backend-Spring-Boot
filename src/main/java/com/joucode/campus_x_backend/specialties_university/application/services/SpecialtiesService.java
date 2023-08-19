package com.joucode.campus_x_backend.specialties_university.application.services;

import com.joucode.campus_x_backend.specialties_university.domain.models.Specialties;
import com.joucode.campus_x_backend.specialties_university.domain.ports.input.CreateSpecialtiesUseCase;
import com.joucode.campus_x_backend.specialties_university.domain.ports.input.RetrieveSpecialtiesUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SpecialtiesService implements
        CreateSpecialtiesUseCase,
        RetrieveSpecialtiesUseCase {

    private final CreateSpecialtiesUseCase createSpecialty;

    private final RetrieveSpecialtiesUseCase retrieveSpecialty;

    @Override
    public Specialties save(Specialties specialties) {
        return createSpecialty.save(specialties);
    }

    @Override
    public Specialties getById(Long id) {
        return retrieveSpecialty.getById(id);
    }

    @Override
    public List<Specialties> getAll() {
        return retrieveSpecialty.getAll();
    }

}
