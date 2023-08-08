package com.joucode.campus_x_backend.auth.infrastructure.adapters.input;

import com.joucode.campus_x_backend.auth.application.services.AuthService;
import com.joucode.campus_x_backend.auth.domain.models.Auth;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.request.AuthLoginRequest;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.request.AuthRegisterRequest;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.mappers.AuthMapper;
import com.joucode.campus_x_backend.common.mappers.ResponseMapper;
import com.joucode.campus_x_backend.common.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthRestAdapter {

    private final AuthService authService;

    private final AuthMapper authMapper;

    private final ResponseMapper responseMapper;

    @PostMapping("/login")
    private ResponseEntity<Response<Auth>> authLogin(@RequestBody @Valid AuthLoginRequest authLoginRequest) {
        Auth authLogin = authService.authLogin(authMapper.toUser(authLoginRequest));
        return new ResponseEntity<>(responseMapper.toResponse(authLogin, OK), OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Response<Auth>> authRegister(@RequestBody @Valid AuthRegisterRequest authRegisterRequest){
        Auth authResponse = authService.authRegister(authMapper.toUser(authRegisterRequest));
        return new ResponseEntity<>(responseMapper.toResponse(authResponse, CREATED), CREATED);
    }

    @PostMapping("/check-available-email")
    public ResponseEntity<Response> checkAvailableEmail(@RequestBody AuthLoginRequest authLoginRequest) {
        return checkAvailability("email", authLoginRequest.getEmail());
    }

    @PostMapping("/check-available-user-name")
    public ResponseEntity<Response> checkAvailableUserName(@RequestBody AuthLoginRequest authLoginRequest) {
        return checkAvailability("user_name", authLoginRequest.getUserName());
    }

    private ResponseEntity<Response> checkAvailability(String fieldName, String value) {

        Boolean state = fieldName.equals("email")
                ? authService.checkAvailableEmail(value)
                : authService.checkAvailableUserName(value);

        Map<String, Object> data = Map.of(fieldName, value, "state", state);

        Response response = new Response(OK.value(), OK.name(), data);
        return ResponseEntity.ok(response);

    }


}
