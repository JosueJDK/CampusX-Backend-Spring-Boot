package com.joucode.campus_x_backend.university.domain.models;

import com.joucode.campus_x_backend.university.domain.enums.UniversityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class University {

    private Long universityId;

    private UniversityType universityType;

    private String name;

}
