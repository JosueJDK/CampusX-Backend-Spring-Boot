package com.joucode.campus_x_backend.province.infrastructure.input;

import com.joucode.campus_x_backend.common.mappers.ResponseMapper;
import com.joucode.campus_x_backend.common.response.Response;
import com.joucode.campus_x_backend.province.application.services.ProvinceService;
import com.joucode.campus_x_backend.province.domain.models.Province;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/province")
@RequiredArgsConstructor
public class ProvinceRestAdapter {

    private final ProvinceService service;
    private final ResponseMapper responseMapper;

    @GetMapping("/all")
    private ResponseEntity<Response<List<Province>>> getAllProvinces(){
        List<Province> provinces = service.getAll();
        return new ResponseEntity<>(responseMapper.toResponse(provinces, OK), OK);
    }

}
