package com.joucode.campus_x_backend.user.infrastructure.adapters.input;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserRestAdapter {

    @GetMapping()
    private ResponseEntity getUsers(){
        return new ResponseEntity<>("HELLO", HttpStatus.OK);
    }


}
