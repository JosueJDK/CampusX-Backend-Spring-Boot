package com.joucode.campus_x_backend.address.application.province.use_cases;

import com.joucode.campus_x_backend.address.domain.province.models.Province;
import com.joucode.campus_x_backend.address.domain.province.ports.input.RetrieveProvinceUseCase;
import com.joucode.campus_x_backend.address.domain.province.ports.output.ProvinceRepositporyPort;
import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveProvinceUseCaseImpl implements RetrieveProvinceUseCase {

    private final ProvinceRepositporyPort repositporyPort;

    @Override
    public Province getById(Long id) {
        return repositporyPort.getById(id).orElseThrow(
                () -> new NotFoundException("La provincia no existe")
        );
    }

    @Override
    public List<Province> getAll() {
        return repositporyPort.getAll();
    }
}
