package com.joucode.campus_x_backend.university.application.use_cases.specialty;

import com.joucode.campus_x_backend.university.domain.models.Specialty;
import com.joucode.campus_x_backend.university.domain.ports.input.specialty.CreateSpecialtyUseCase;
import com.joucode.campus_x_backend.university.domain.ports.output.SpecialtyRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateSpecialtyUseCaseImpl implements CreateSpecialtyUseCase {

    private final SpecialtyRepositoryPort repositoryPort;

    @Override
    public Specialty save(Specialty specialty) {
        return repositoryPort.save(specialty);
    }
}
