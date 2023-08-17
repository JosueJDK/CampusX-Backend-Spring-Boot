package com.joucode.campus_x_backend.address.domain.address.models;

import com.joucode.campus_x_backend.address.domain.city.models.City;
import com.joucode.campus_x_backend.address.domain.country.models.Country;
import com.joucode.campus_x_backend.address.domain.district.models.District;

public class Address {

    private Long addressId;

    private Country country;

    private City city;

    private com.joucode.campus_x_backend.address.domain.province.models.Province province;

    private District district;

}
