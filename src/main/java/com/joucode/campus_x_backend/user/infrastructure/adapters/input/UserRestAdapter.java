package com.joucode.campus_x_backend.user.infrastructure.adapters.input;

import com.joucode.campus_x_backend.common.response.Response;
import com.joucode.campus_x_backend.user.application.services.UserService;
import com.joucode.campus_x_backend.user.domain.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserRestAdapter {

    private final UserService userService;

    @GetMapping("/{user_id}")
    private ResponseEntity<Response<User>> getUserById(@PathVariable(value = "user_id") Long user_id){
        User user = userService.getById(user_id);
        Response response = new Response(OK.value(), OK.name(), user);
        return new ResponseEntity<>(response, OK);
    }


}
