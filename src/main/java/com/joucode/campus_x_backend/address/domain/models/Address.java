package com.joucode.campus_x_backend.address.domain.models;

import com.joucode.campus_x_backend.city.domain.models.City;
import com.joucode.campus_x_backend.country.domain.models.Country;
import com.joucode.campus_x_backend.district.domain.models.District;
import com.joucode.campus_x_backend.province.domain.models.Province;

public class Address {

    private Long addressId;

    private Country country;

    private City city;

    private Province province;

    private District district;

}
