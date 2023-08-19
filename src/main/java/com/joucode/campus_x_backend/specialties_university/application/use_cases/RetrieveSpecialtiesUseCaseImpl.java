package com.joucode.campus_x_backend.specialties_university.application.use_cases;

import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.specialties_university.domain.models.Specialties;
import com.joucode.campus_x_backend.specialties_university.domain.ports.input.RetrieveSpecialtiesUseCase;
import com.joucode.campus_x_backend.specialties_university.domain.ports.output.SpecialtiesRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveSpecialtiesUseCaseImpl implements RetrieveSpecialtiesUseCase {

    private final SpecialtiesRepositoryPort repositoryPort;

    @Override
    public Specialties getById(Long id) {
        return repositoryPort.findById(id).orElseThrow(
                () -> new NotFoundException("La especialidad no existe.")
        );
    }

    @Override
    public List<Specialties> getAll() {
        return repositoryPort.findAll();
    }
}
