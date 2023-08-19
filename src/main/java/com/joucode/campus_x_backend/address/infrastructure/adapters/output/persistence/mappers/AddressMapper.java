package com.joucode.campus_x_backend.address.infrastructure.adapters.output.persistence.mappers;

import com.joucode.campus_x_backend.address.domain.models.Address;
import com.joucode.campus_x_backend.address.infrastructure.adapters.input.rest.data.request.AddressRequest;
import com.joucode.campus_x_backend.address.infrastructure.adapters.output.persistence.entity.AddressEntity;
import com.joucode.campus_x_backend.city.domain.models.City;
import com.joucode.campus_x_backend.country.domain.models.Country;
import com.joucode.campus_x_backend.district.domain.models.District;
import com.joucode.campus_x_backend.province.domain.models.Province;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class AddressMapper {

    @Autowired
    private ModelMapper mapper;

    public AddressEntity toEntity(Address address){
        return mapper.map(address, AddressEntity.class);
    }

    public Address toModel(AddressEntity address){
        return mapper.map(address, Address.class);
    }

    public Address toAddress(AddressRequest request){
        return Address.builder()
                .country(Country.builder().countryId(request.getCountry()).build())
                .city(City.builder().cityId(request.getCity()).build())
                .province(Province.builder().provinceId(request.getProvince()).build())
                .district(District.builder().districtId(request.getDistrict()).build())
                .build();
    }

    public List<Address> toList(List<AddressEntity> address) {
        return address.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
