package com.joucode.campus_x_backend.address.domain.city.models;

import com.joucode.campus_x_backend.address.infrastructure.adapters.country.output.persistence.entity.CountryEntity;

public class City {

    private Long cityId;

    private String name;

    private CountryEntity countryEntity;

}
