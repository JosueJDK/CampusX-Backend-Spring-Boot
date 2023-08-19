package com.joucode.campus_x_backend.country.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    private Long countryId;

    private String name;

    private String code;

}
