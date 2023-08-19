package com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.output.persistence.entity;

import com.joucode.campus_x_backend.university.domain.enums.FacultyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
@Table(name = "specialty_university_table")
public class SpecialtiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private Long areaId;

    @Enumerated(EnumType.STRING)
    @Column(name = "specialty_type")
    private FacultyType specialType;

    @Column(name = "name")
    private String name;
        

}
