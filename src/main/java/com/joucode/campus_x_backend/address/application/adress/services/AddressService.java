package com.joucode.campus_x_backend.address.application.adress.services;

import com.joucode.campus_x_backend.address.domain.address.models.Address;
import com.joucode.campus_x_backend.address.domain.address.ports.input.CreateAddressUseCase;
import com.joucode.campus_x_backend.address.domain.address.ports.input.RetrieveAddressUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AddressService implements
        CreateAddressUseCase,
        RetrieveAddressUseCase {

    private final CreateAddressUseCase createAddress;
    private final RetrieveAddressUseCase retrieveAddress;

    @Override
    public Address save(Address address) {
        return createAddress.save(address);
    }

    @Override
    public Address findById(Long id) {
        return retrieveAddress.findById(id);
    }

    @Override
    public List<Address> getAll() {
        return retrieveAddress.getAll();
    }
}