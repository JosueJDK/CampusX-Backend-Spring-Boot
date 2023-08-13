package com.joucode.campus_x_backend.university.domain.ports.input.specialty;

import com.joucode.campus_x_backend.university.domain.models.Specialty;

public interface CreateSpecialtyUseCase {

    Specialty save(Specialty specialty);

}
