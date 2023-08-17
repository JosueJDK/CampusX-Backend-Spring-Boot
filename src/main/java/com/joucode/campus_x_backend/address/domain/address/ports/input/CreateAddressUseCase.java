package com.joucode.campus_x_backend.address.domain.address.ports.input;

import com.joucode.campus_x_backend.address.domain.address.models.Address;

public interface CreateAddressUseCase {

    Address save(Address address);

}
