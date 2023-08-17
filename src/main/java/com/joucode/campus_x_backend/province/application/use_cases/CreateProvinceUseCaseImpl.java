package com.joucode.campus_x_backend.province.application.use_cases;

import com.joucode.campus_x_backend.province.domain.models.Province;
import com.joucode.campus_x_backend.province.domain.ports.input.CreateProvinceUseCase;
import com.joucode.campus_x_backend.province.domain.ports.output.ProvinceRepositporyPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProvinceUseCaseImpl implements CreateProvinceUseCase {

    private final ProvinceRepositporyPort repositporyPort;

    @Override
    public Province save(Province province) {
        return repositporyPort.save(province);
    }
}
