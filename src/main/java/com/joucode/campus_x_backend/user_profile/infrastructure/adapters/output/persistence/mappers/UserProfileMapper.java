package com.joucode.campus_x_backend.user_profile.infrastructure.adapters.output.persistence.mappers;

import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;
import com.joucode.campus_x_backend.user_profile.infrastructure.adapters.output.persistence.entity.UserProfileEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserProfileMapper {

    @Autowired
    private ModelMapper mapper;

    public UserProfileEntity toEntity(UserProfile userProfile){
        return mapper.map(userProfile, UserProfileEntity.class);
    }

    public UserProfile toModel(UserProfileEntity userProfile){
        return mapper.map(userProfile, UserProfile.class);
    }

}
