package com.joucode.campus_x_backend.university.application.use_cases;

import com.joucode.campus_x_backend.university.domain.models.University;
import com.joucode.campus_x_backend.university.domain.ports.input.CreateUniversityUseCase;
import com.joucode.campus_x_backend.university.domain.ports.output.UniversityRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUniversityUseCaseImpl implements CreateUniversityUseCase {

    private final UniversityRepositoryPort repositoryPort;

    @Override
    public University save(University university) {
        return repositoryPort.save(university);
    }
}
