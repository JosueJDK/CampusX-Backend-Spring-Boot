package com.joucode.campus_x_backend.specialties_university.domain.ports.input;

import com.joucode.campus_x_backend.specialties_university.domain.models.Specialties;

public interface CreateSpecialtiesUseCase {

    Specialties save(Specialties specialties);

}
