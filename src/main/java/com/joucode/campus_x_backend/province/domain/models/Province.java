package com.joucode.campus_x_backend.province.domain.models;

import com.joucode.campus_x_backend.city.domain.models.City;
import com.joucode.campus_x_backend.city.infrastructure.output.persistence.entity.CityEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {

    private Long provinceId;

    private String name;

    private City city;


}
