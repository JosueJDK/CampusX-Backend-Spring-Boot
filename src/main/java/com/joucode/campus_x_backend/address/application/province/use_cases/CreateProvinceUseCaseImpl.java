package com.joucode.campus_x_backend.address.application.province.use_cases;

import com.joucode.campus_x_backend.address.domain.province.models.Province;
import com.joucode.campus_x_backend.address.domain.province.ports.input.CreateProvinceUseCase;
import com.joucode.campus_x_backend.address.domain.province.ports.output.ProvinceRepositporyPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProvinceUseCaseImpl implements CreateProvinceUseCase {

    private final ProvinceRepositporyPort repositporyPort;

    @Override
    public Province save(Province province) {
        return repositporyPort.save(province);
    }
}
