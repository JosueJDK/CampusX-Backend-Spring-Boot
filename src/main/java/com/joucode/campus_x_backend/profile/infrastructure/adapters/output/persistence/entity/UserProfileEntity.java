package com.joucode.campus_x_backend.profile.infrastructure.adapters.output.persistence.entity;

import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.enums.GenderName;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
@Table(name = "user_profile_table")
public class UserProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_profile_id")
    private Long userProfileId;

    @Column(name = "is_public", nullable = false)
    private boolean isPublic;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "about_user")
    private String aboutUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private GenderName gender;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "age", nullable = false)
    private Integer age;

}