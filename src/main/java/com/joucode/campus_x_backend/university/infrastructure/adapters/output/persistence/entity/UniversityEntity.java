package com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.entity;

import com.joucode.campus_x_backend.university.domain.enums.UniversityType;
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
@Table(name = "university_table")
public class UniversityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Long universityId;

    @Enumerated(EnumType.STRING)
    @Column(name = "university_type", nullable = false)
    private UniversityType universityType;

    @Column(name = "name", nullable = false, length = 250)
    private String name;



}
