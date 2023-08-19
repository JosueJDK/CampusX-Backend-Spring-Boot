package com.joucode.campus_x_backend.district.infrastructure.input;

import com.joucode.campus_x_backend.common.mappers.ResponseMapper;
import com.joucode.campus_x_backend.common.response.Response;
import com.joucode.campus_x_backend.district.application.services.DistrictService;
import com.joucode.campus_x_backend.district.domain.models.District;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/district")
@RequiredArgsConstructor
public class DistrictRestAdapter {

    private final DistrictService service;
    private final ResponseMapper responseMapper;

    @GetMapping("/all")
    private ResponseEntity<Response<List<District>>> getAllCountries(){
        List<District> districts = service.getAll();
        return new ResponseEntity<>(responseMapper.toResponse(districts, OK),OK);
    }
}
