package com.joucode.campus_x_backend.address.domain.address.models;

import com.joucode.campus_x_backend.address.domain.city.models.City;
import com.joucode.campus_x_backend.address.domain.country.models.Country;
import com.joucode.campus_x_backend.address.domain.district.models.District;
import com.joucode.campus_x_backend.address.domain.province.models.Province;

public class Address {

    private Long addressId;

    private Country country;

    private City city;

    private Province province;

    private District district;

}
