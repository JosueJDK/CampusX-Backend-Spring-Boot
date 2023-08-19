package com.joucode.campus_x_backend.city.domain.models;

import com.joucode.campus_x_backend.country.domain.models.Country;
import com.joucode.campus_x_backend.country.infrastructure.output.persistence.entity.CountryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    private Long cityId;

    private String name;

    private Country country;

}
