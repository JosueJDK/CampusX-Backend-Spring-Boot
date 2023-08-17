package com.joucode.campus_x_backend.address.domain.ports.input;

import com.joucode.campus_x_backend.address.domain.models.Address;

public interface CreateAddressUseCase {

    Address save(Address address);

}
