package com.joucode.campus_x_backend.address.infrastructure.adapters.input;

import com.joucode.campus_x_backend.address.application.services.AddressService;
import com.joucode.campus_x_backend.address.domain.models.Address;
import com.joucode.campus_x_backend.address.infrastructure.adapters.input.rest.data.request.AddressRequest;
import com.joucode.campus_x_backend.address.infrastructure.adapters.output.persistence.mappers.AddressMapper;
import com.joucode.campus_x_backend.common.mappers.ResponseMapper;
import com.joucode.campus_x_backend.common.response.Response;
import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressRestAdapter {

    private final AddressService service;
    private final AddressMapper mapper;
    private final ResponseMapper responseMapper;

    @PostMapping("/{id_user_profile}/create")
    private ResponseEntity<Response<UserProfile>> createAddressProfile(
            @PathVariable(value = "id_user_profile") Long userProfileId,
            @Valid @RequestBody AddressRequest addressRequest
    ){
        UserProfile userProfile = service.save(userProfileId, mapper.toAddress(addressRequest));
        return new ResponseEntity<>(responseMapper.toResponse(userProfile, OK), OK);
    }

}
