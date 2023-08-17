package com.joucode.campus_x_backend.address.application.province.services;

import com.joucode.campus_x_backend.address.domain.province.models.Province;
import com.joucode.campus_x_backend.address.domain.province.ports.input.CreateProvinceUseCase;
import com.joucode.campus_x_backend.address.domain.province.ports.input.RetrieveProvinceUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ProvinceService implements
        CreateProvinceUseCase,
        RetrieveProvinceUseCase {

    private final CreateProvinceUseCase createProvince;

    private final RetrieveProvinceUseCase retrieveProvince;

    @Override
    public Province save(Province province) {
        return createProvince.save(province);
    }

    @Override
    public Province getById(Long id) {
        return retrieveProvince.getById(id);
    }

    @Override
    public List<Province> getAll() {
        return retrieveProvince.getAll();
    }
}
