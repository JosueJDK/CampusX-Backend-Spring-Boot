package com.joucode.campus_x_backend.specialties_university.domain.ports.input;

import com.joucode.campus_x_backend.specialties_university.domain.models.Specialties;
import java.util.List;

public interface RetrieveSpecialtiesUseCase {

    Specialties getById(Long  id);

    List<Specialties> getAll();

}
