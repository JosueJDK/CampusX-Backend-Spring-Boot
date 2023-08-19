package com.joucode.campus_x_backend.district.domain.models;

import com.joucode.campus_x_backend.city.domain.models.City;
import com.joucode.campus_x_backend.province.domain.models.Province;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    private Long districtId;

    private String name;

    private Province province;

    private City city;


}
