package com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.entity;

import com.joucode.campus_x_backend.user_profile.infrastructure.adapters.output.persistence.entity.UserProfileEntity;
import com.joucode.campus_x_backend.specialties_university.infrastructure.adapters.output.persistence.entity.SpecialtiesEntity;
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
@Table(name = "info_university_table")
public class InfoUniversityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_university_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "university_id", nullable = false)
    private UniversityEntity universityEntity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "specialty_id", nullable = false)
    private SpecialtiesEntity specialtiesEntity;

    @OneToOne(mappedBy = "infoUniversity", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private UserProfileEntity userProfile;

}
