package com.joucode.campus_x_backend.university.application.services;

import com.joucode.campus_x_backend.university.domain.models.University;
import com.joucode.campus_x_backend.university.domain.ports.input.university.CreateUniversityUseCase;
import com.joucode.campus_x_backend.university.domain.ports.input.university.RetrieveUniversityUseCase;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class UniversityService implements
        CreateUniversityUseCase,
        RetrieveUniversityUseCase {

    private final CreateUniversityUseCase createUniversity;

    private final RetrieveUniversityUseCase retrieveUniversity;

    @Override
    public University save(University university) {
        return createUniversity.save(university);
    }

    @Override
    public University getById(Long id) {
        return retrieveUniversity.getById(id);
    }

    @Override
    public List<University> getAll() {
        return retrieveUniversity.getAll();
    }


}
