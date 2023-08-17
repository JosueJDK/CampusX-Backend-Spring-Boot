package com.joucode.campus_x_backend.profile.domain.models;

import com.joucode.campus_x_backend.address.infrastructure.adapters.output.persistence.entity.AddressEntity;
import com.joucode.campus_x_backend.profile.domain.enums.ZodicalSign;
import com.joucode.campus_x_backend.university.infrastructure.adapters.output.persistence.entity.InfoUniversityEntity;
import com.joucode.campus_x_backend.user.domain.enums.GenderName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

    private Long userProfileId;

    private boolean isPublic;

    private String firstName;

    private String lastName;

    private String aboutUser;

    private GenderName gender;

    private LocalDate dateOfBirth;

    private Integer age;

    private ZodicalSign zodiacSign;

    private AddressEntity address;

    private InfoUniversityEntity university;

}
