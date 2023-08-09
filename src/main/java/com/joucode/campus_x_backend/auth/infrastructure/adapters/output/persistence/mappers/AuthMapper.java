package com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.mappers;

import com.joucode.campus_x_backend.auth.domain.models.Auth;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.request.AuthLoginRequest;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.request.AuthRegisterRequest;
import com.joucode.campus_x_backend.user.domain.models.Role;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.profile.domain.models.UserProfile;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.RoleEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.enums.ActivityStatusName;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class AuthMapper {

    @Autowired
    private ModelMapper mapper;

    public Auth toAuth(User user, String accessToken, String refreshToken){
        return new Auth(user, accessToken, refreshToken);
    }

    public Role toRole(RoleEntity roleEntity){
        return mapper.map(roleEntity, Role.class);
    }

    public User toUser(UserEntity userEntity){
        return mapper.map(userEntity, User.class);
    }

    public User toUser(AuthLoginRequest authLoginRequest){

        return User.builder()
                .email(authLoginRequest.getLogin())
                .username(authLoginRequest.getLogin())
                .password(authLoginRequest.getPassword())
                .build();
    }

    public User toUser(AuthRegisterRequest authRegisterRequest){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        UserProfile userProfile = UserProfile.builder()
                .isPublic(true)
                .firstName(authRegisterRequest.getFirstName())
                .lastName(authRegisterRequest.getLastName())
                .gender(authRegisterRequest.getGender())
                .dateOfBirth(LocalDate.parse(authRegisterRequest.getDateOfBirth(), formatter))
                .age(LocalDate.now().getYear() - LocalDate.parse(authRegisterRequest.getDateOfBirth(), formatter).getYear())
                .build();

        return User.builder()
                .username(authRegisterRequest.getUsername())
                .email(authRegisterRequest.getEmail())
                .password(authRegisterRequest.getPassword())
                .phoneNumber(authRegisterRequest.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .verifiedAccount(true)
                .activityStatus(ActivityStatusName.OFFLINE)
                .incorrectLoginCounter(0)
                .isBlocked(false)
                .isBanned(false)
                .userProfile(userProfile)
                .build();
    }

    public List<String> toRoleNames(List<RoleEntity> roleEntities) {
        return roleEntities.stream()
                .map(roleEntity -> roleEntity.getName().toString())
                .collect(Collectors.toList());
    }

}