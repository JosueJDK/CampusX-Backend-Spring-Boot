package com.joucode.campus_x_backend.address.infrastructure.adapters.address.output.persistence;

import com.joucode.campus_x_backend.address.domain.address.models.Address;
import com.joucode.campus_x_backend.address.domain.address.ports.output.AddressRepositoryPort;
import com.joucode.campus_x_backend.address.infrastructure.adapters.address.output.persistence.entity.AddressEntity;
import com.joucode.campus_x_backend.address.infrastructure.adapters.address.output.persistence.mappers.AddressMapper;
import com.joucode.campus_x_backend.address.infrastructure.adapters.address.output.persistence.repository.AddressRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AddressPersistenceAdapter implements AddressRepositoryPort {

    private final AddressRepository repository;

    private final AddressMapper mapper;

    @Override
    public Address save(Address address) {
        return mapper.toModel(repository.save(mapper.toEntity(address)));
    }

    @Override
    public Optional<Address> findById(Long id) {
        Optional<AddressEntity> address = repository.findById(id);
        return address.map(mapper::toModel);
    }

    @Override
    public List<Address> getAll() {
        return mapper.toList(repository.findAll());
    }
}
