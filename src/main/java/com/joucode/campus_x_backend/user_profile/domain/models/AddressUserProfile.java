package com.joucode.campus_x_backend.user_profile.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddressUserProfile {

    private Long country;

    private Long city;

    private Long province;

    private Long district;

}
