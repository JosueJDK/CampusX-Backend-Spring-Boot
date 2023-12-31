package com.joucode.campus_x_backend.country.infrastructure.input;

import com.joucode.campus_x_backend.country.application.services.CountryService;
import com.joucode.campus_x_backend.country.domain.models.Country;
import com.joucode.campus_x_backend.common.mappers.ResponseMapper;
import com.joucode.campus_x_backend.common.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/country")
@RequiredArgsConstructor
public class CountryRestAdapter {

    private final CountryService service;

    private final ResponseMapper responseMapper;

    @GetMapping("/all")
    private ResponseEntity<Response<List<Country>>> getAllCountries(){
        List<Country> countries = service.getAll();
        return new ResponseEntity<>(responseMapper.toResponse(countries, OK),OK);
    }

}
