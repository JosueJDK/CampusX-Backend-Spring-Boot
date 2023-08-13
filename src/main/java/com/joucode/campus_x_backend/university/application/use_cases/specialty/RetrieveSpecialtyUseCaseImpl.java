package com.joucode.campus_x_backend.university.application.use_cases.specialty;

import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.university.domain.models.Specialty;
import com.joucode.campus_x_backend.university.domain.ports.input.specialty.RetrieveSpecialtyUseCase;
import com.joucode.campus_x_backend.university.domain.ports.output.SpecialtyRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveSpecialtyUseCaseImpl implements RetrieveSpecialtyUseCase {

    private final SpecialtyRepositoryPort repositoryPort;

    @Override
    public Specialty getById(Long id) {
        return repositoryPort.findById(id).orElseThrow(
                () -> new NotFoundException("La especialidad no existe.")
        );
    }

    @Override
    public List<Specialty> getAll() {
        return repositoryPort.findAll();
    }
}
