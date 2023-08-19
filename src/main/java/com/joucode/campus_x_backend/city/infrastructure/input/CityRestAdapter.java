package com.joucode.campus_x_backend.city.infrastructure.input;

import com.joucode.campus_x_backend.city.application.services.CityService;
import com.joucode.campus_x_backend.city.domain.models.City;
import com.joucode.campus_x_backend.common.mappers.ResponseMapper;
import com.joucode.campus_x_backend.common.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/city")
@RequiredArgsConstructor
public class CityRestAdapter {

    private final CityService service;

    private final ResponseMapper responseMapper;

    @GetMapping("/all")
    private ResponseEntity<Response<List<City>>> getAllCities(){
        List<City> cities = service.getAll();
        return new ResponseEntity<>(responseMapper.toResponse(cities, OK), OK);
    }
}
