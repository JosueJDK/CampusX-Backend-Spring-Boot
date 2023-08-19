package com.joucode.campus_x_backend.university.domain.ports.input;

import com.joucode.campus_x_backend.university.domain.models.University;
import java.util.List;

public interface RetrieveUniversityUseCase {

    University getById(Long id);

    List<University> getAll();

}
