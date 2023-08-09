package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.mappers;

import com.joucode.campus_x_backend.user.domain.models.Role;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.profile.domain.models.UserProfile;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.joucode.campus_x_backend.profile.infrastructure.adapters.output.persistence.entity.UserProfileEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    @Autowired
    private ModelMapper mapper;

    public UserEntity toEntity(User user){
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity.setUserProfileEntity(mapper.map(user.getUserProfile(), UserProfileEntity.class));
        return userEntity;
    }

    public User toUser(UserEntity userEntity){
        User user = mapper.map(userEntity, User.class);
        user.setUserProfile(mapper.map(user.getUserProfile(), UserProfile.class));
        return user;
    }

    public Role toRole(RoleEntity roleEntity){
        return mapper.map(roleEntity, Role.class);
    }

    public List<User> toUserList(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(this::toUser)
                .collect(Collectors.toList());
    }


}