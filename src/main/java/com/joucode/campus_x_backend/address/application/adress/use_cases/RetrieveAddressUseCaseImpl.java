package com.joucode.campus_x_backend.address.application.adress.use_cases;

import com.joucode.campus_x_backend.address.domain.address.models.Address;
import com.joucode.campus_x_backend.address.domain.address.ports.input.RetrieveAddressUseCase;
import com.joucode.campus_x_backend.address.domain.address.ports.output.AddressRepositoryPort;
import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveAddressUseCaseImpl implements RetrieveAddressUseCase {

    private final AddressRepositoryPort repositoryPort;

    @Override
    public Address findById(Long id) {
        return repositoryPort.findById(id).orElseThrow(
                () -> new NotFoundException("La direccion no existe!")
        );
    }

    @Override
    public List<Address> getAll() {
        return repositoryPort.getAll();
    }
}
