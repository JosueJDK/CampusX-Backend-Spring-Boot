package com.joucode.campus_x_backend.specialties_university.application.use_cases;

import com.joucode.campus_x_backend.specialties_university.domain.models.Specialties;
import com.joucode.campus_x_backend.specialties_university.domain.ports.input.CreateSpecialtiesUseCase;
import com.joucode.campus_x_backend.specialties_university.domain.ports.output.SpecialtiesRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateSpecialtiesUseCaseImpl implements CreateSpecialtiesUseCase {

    private final SpecialtiesRepositoryPort repositoryPort;

    @Override
    public Specialties save(Specialties specialties) {
        return repositoryPort.save(specialties);
    }
}
