package com.joucode.campus_x_backend.address.application.adress.use_cases;

import com.joucode.campus_x_backend.address.domain.address.models.Address;
import com.joucode.campus_x_backend.address.domain.address.ports.input.CreateAddressUseCase;
import com.joucode.campus_x_backend.address.domain.address.ports.output.AddressRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAddressUseCaseImpl implements CreateAddressUseCase {

    private final AddressRepositoryPort repositoryPort;

    @Override
    public Address save(Address address) {
        return repositoryPort.save(address);
    }
}
