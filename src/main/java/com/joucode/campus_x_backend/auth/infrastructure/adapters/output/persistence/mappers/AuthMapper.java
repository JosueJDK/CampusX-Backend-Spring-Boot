package com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.mappers;

import com.joucode.campus_x_backend.auth.domain.models.Auth;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.request.AuthLoginRequest;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.request.AuthRegisterRequest;
import com.joucode.campus_x_backend.common.response.Response;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class AuthMapper {

    @Autowired
    private ModelMapper mapper;

    public Auth toAuth(User user, String accessToken, String refreshToken){
        return new Auth(user, accessToken, refreshToken);
    }

    public User toUser(UserEntity userEntity){
        return mapper.map(userEntity, User.class);
    }

    public User toUser(AuthLoginRequest authLoginRequest){
        return mapper.map(authLoginRequest, User.class);
    }

    public User toUser(AuthRegisterRequest authRegisterRequest){
        return mapper.map(authRegisterRequest, User.class);
    }

    public UserEntity toEntity(User user){
        return mapper.map(user, UserEntity.class);
    }
}