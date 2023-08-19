package com.joucode.campus_x_backend.address.application.services;

import com.joucode.campus_x_backend.address.domain.models.Address;
import com.joucode.campus_x_backend.address.domain.ports.input.CreateAddressUserProfileUseCase;
import com.joucode.campus_x_backend.address.domain.ports.input.RetrieveAddressUseCase;
import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AddressService implements
        CreateAddressUserProfileUseCase,
        RetrieveAddressUseCase {

    private final CreateAddressUserProfileUseCase createAddress;
    private final RetrieveAddressUseCase retrieveAddress;

    @Override
    public UserProfile save(Long userProfileId, Address address) {
        return createAddress.save(userProfileId, address);
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
