package com.joucode.campus_x_backend.university.domain.ports.input.specialty;

import com.joucode.campus_x_backend.university.domain.models.Specialty;
import java.util.List;

public interface RetrieveSpecialtyUseCase {

    Specialty getById(Long  id);

    List<Specialty> getAll();

}
