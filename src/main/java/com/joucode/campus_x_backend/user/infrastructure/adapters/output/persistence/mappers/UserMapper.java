package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.mappers;

import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.infrastructure.adapters.input.rest.data.request.UserRequest;
import com.joucode.campus_x_backend.user.infrastructure.adapters.input.rest.data.response.UserResponse;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserMapper {

    @Autowired
    private ModelMapper mapper;

    public User toUser(UserEntity userEntity) {
        return mapper.map(userEntity, User.class);
    }

    public User toUser(Optional<UserEntity> userEntity){
        return mapper.map(userEntity, User.class);
    }

    public User toUser(List<UserEntity> userEntity){
        return mapper.map(userEntity, User.class);
    }

    public UserEntity toEntity(User user){
        return mapper.map(user, UserEntity.class);
    }
}