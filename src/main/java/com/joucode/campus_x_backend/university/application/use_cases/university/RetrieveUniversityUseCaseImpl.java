package com.joucode.campus_x_backend.university.application.use_cases.university;

import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.university.domain.models.University;
import com.joucode.campus_x_backend.university.domain.ports.input.university.RetrieveUniversityUseCase;
import com.joucode.campus_x_backend.university.domain.ports.output.UniversityRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveUniversityUseCaseImpl implements RetrieveUniversityUseCase {

    private final UniversityRepositoryPort repositoryPort;

    @Override
    public University getById(Long id) {
        return repositoryPort.findById(id).orElseThrow(
                () -> new NotFoundException("La universidad no existe.")
        );
    }

    @Override
    public List<University> getAll() {
        return repositoryPort.findAll();
    }

}
