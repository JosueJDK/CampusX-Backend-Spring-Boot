package com.joucode.campus_x_backend.address.infrastructure.adapters.output.persistence.mappers;

import com.joucode.campus_x_backend.address.domain.models.Address;
import com.joucode.campus_x_backend.address.infrastructure.adapters.output.persistence.entity.AddressEntity;
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

    public List<Address> toList(List<AddressEntity> address) {
        return address.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
