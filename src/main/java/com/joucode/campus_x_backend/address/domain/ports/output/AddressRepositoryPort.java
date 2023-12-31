package com.joucode.campus_x_backend.address.domain.ports.output;

import com.joucode.campus_x_backend.address.domain.models.Address;
import java.util.List;
import java.util.Optional;

public interface AddressRepositoryPort {

    Address save(Address address);

    Optional<Address> findById(Long id);

    List<Address> getAll();

}
