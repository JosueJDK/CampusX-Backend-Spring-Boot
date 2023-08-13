package com.joucode.campus_x_backend.auth.infrastructure.adapters.input;

import com.joucode.campus_x_backend.auth.application.services.AuthService;
import com.joucode.campus_x_backend.auth.domain.models.Auth;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.request.*;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.mappers.AuthMapper;
import com.joucode.campus_x_backend.common.mappers.ResponseMapper;
import com.joucode.campus_x_backend.common.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@Slf4j
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
        log.info("---- Authenticate user: {}", authLogin.getUser().getUsername());
        return new ResponseEntity<>(responseMapper.toResponse(authLogin, OK), OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Response<Auth>> authRegister(@RequestBody @Valid AuthRegisterRequest authRegisterRequest){
        Auth authResponse = authService.authRegister(authMapper.toUser(authRegisterRequest));
        log.info("---- Create user: {}", authResponse.getUser().getUsername());
        return new ResponseEntity(responseMapper.toResponse(authResponse, CREATED), CREATED);
    }

    @GetMapping("/logout/{user_id}")
    private ResponseEntity<?> authLogout(@PathVariable(value = "user_id") Long user_id) {
        authService.authLogoutUserId(user_id);
        log.info("---- Loguot user with id: {}", user_id);
        return new ResponseEntity<>(OK);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<Response<Auth>> authRefreshToken(@RequestBody AuthRefreshTokenRequest request){
        Auth authResponse = authService.refreshToken(request.getRefreshToken());
        log.info("---- Refresh Token user: {}", authResponse.getUser().getUsername());
        return new ResponseEntity<>(responseMapper.toResponse(authResponse, CREATED), CREATED);
    }

    @PostMapping("/check-available-token")
    public ResponseEntity<Response> checkAvailableEmail(@RequestBody AuthCheckTokenRequest tokenRequest) {
        Boolean state = authService.checkAvailableToken(tokenRequest.getToken());
        Response response = new Response(OK.value(), OK.name(), Map.of("isValid", state));
        return new ResponseEntity<>(response, OK);
    }

    @PostMapping("/check-available-email")
    public ResponseEntity<Response> checkAvailableEmail(@RequestBody AuthCheckEmailRequest emailRequest) {
        return checkAvailability("email", emailRequest.getEmail());
    }

    @PostMapping("/check-available-user-name")
    public ResponseEntity<Response> checkAvailableUserName(@RequestBody AuthCheckUserNameRequest userNameRequest) {
        return checkAvailability("user_name", userNameRequest.getUserName());
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
