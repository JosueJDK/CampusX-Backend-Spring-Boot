package com.joucode.campus_x_backend.address.domain.address.ports.input;

import com.joucode.campus_x_backend.address.domain.address.models.Address;
import java.util.List;

public interface RetrieveAddressUseCase {
    Address findById(Long id);

    List<Address> getAll();

}
