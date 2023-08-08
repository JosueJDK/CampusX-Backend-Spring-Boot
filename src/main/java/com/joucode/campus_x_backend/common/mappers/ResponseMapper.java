package com.joucode.campus_x_backend.common.mappers;

import com.joucode.campus_x_backend.common.response.Response;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.infrastructure.adapters.input.rest.data.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class ResponseMapper {

    @Autowired
    private ModelMapper mapper;

    public <T> Response toResponse(T userResponse, HttpStatus httpStatus){
        return new Response(httpStatus.value(), httpStatus.name(), userResponse);
    }

}
