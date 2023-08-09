package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.mappers;

import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.profile.domain.models.UserProfile;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.joucode.campus_x_backend.profile.infrastructure.adapters.output.persistence.entity.UserProfileEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {

    @Autowired
    private ModelMapper mapper;

    public UserEntity toEntity(User user){
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity.setUserProfileEntity(mapper.map(user.getUserProfile(), UserProfileEntity.class));
        return userEntity;
    }

}