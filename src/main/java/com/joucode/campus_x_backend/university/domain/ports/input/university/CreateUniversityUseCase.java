package com.joucode.campus_x_backend.university.domain.ports.input.university;

import com.joucode.campus_x_backend.university.domain.models.University;

public interface CreateUniversityUseCase {

    University save(University university);

}
