package com.joucode.campus_x_backend.user_profile.infrastructure.adapters.input;

import com.joucode.campus_x_backend.common.mappers.ResponseMapper;
import com.joucode.campus_x_backend.common.response.Response;
import com.joucode.campus_x_backend.user_profile.application.service.UserProfileService;
import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;
import com.joucode.campus_x_backend.address.infrastructure.adapters.input.rest.data.request.AddressRequest;
import com.joucode.campus_x_backend.user_profile.infrastructure.adapters.output.persistence.mappers.UserProfileMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileRestAdapter {

    private final UserProfileService service;

    private final ResponseMapper responseMapper;

    @GetMapping("/{id_user_profile}")
    private ResponseEntity<Response<UserProfile>> getUserProfile( @PathVariable(value = "id_user_profile") Long userProfileId){
        UserProfile userProfile = service.findById(userProfileId);
        return new ResponseEntity<>(responseMapper.toResponse(Map.of("userProfile", userProfile), OK), OK);
    }


}
