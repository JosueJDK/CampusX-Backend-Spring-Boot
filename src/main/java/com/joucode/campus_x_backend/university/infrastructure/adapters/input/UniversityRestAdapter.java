package com.joucode.campus_x_backend.university.infrastructure.adapters.input;

import com.joucode.campus_x_backend.common.mappers.ResponseMapper;
import com.joucode.campus_x_backend.common.response.Response;
import com.joucode.campus_x_backend.university.application.services.UniversityService;
import com.joucode.campus_x_backend.university.domain.models.University;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/university")
@RequiredArgsConstructor
public class UniversityRestAdapter {

    private final UniversityService service;

    private final ResponseMapper responseMapper;

    @GetMapping("/all")
    private ResponseEntity<Response<List<University>>> getAllUniversities(){
        List<University> universities= service.getAll();
        return new ResponseEntity<>(responseMapper.toResponse(universities, OK), OK);
    }

}
