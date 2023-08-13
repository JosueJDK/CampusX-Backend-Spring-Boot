package com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.mappers;

import com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.request.AuthLoginRequest;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.input.rest.data.request.AuthRegisterRequest;
import com.joucode.campus_x_backend.profile.domain.enums.ZodicalSign;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.profile.domain.models.UserProfile;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.joucode.campus_x_backend.user.domain.enums.ActivityStatusName;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class AuthMapper {

    @Autowired
    private ModelMapper mapper;

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

    public User toUser(AuthRegisterRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ZodicalSign zodicalSign = getZodiacalSign(request.getDateOfBirth());
        UserProfile userProfile = UserProfile.builder()
                .isPublic(true)
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .dateOfBirth(LocalDate.parse(request.getDateOfBirth(), formatter))
                .age(LocalDate.now().getYear() - LocalDate.parse(request.getDateOfBirth(), formatter).getYear())
                .zodiacSign(zodicalSign)
                .build();

        return User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .verifiedAccount(true)
                .activityStatus(ActivityStatusName.OFFLINE)
                .incorrectLoginCounter(0)
                .isBlocked(false)
                .isBanned(false)
                .userProfile(userProfile)
                .build();
    }

    public static ZodicalSign getZodiacalSign(String dateOfBirth) {
        LocalDate fecha = LocalDate.parse(dateOfBirth);
        int dia = fecha.getDayOfMonth();
        Month mes = fecha.getMonth();

        if ((mes == Month.MARCH && dia >= 21) || (mes == Month.APRIL && dia <= 19)) {
            return ZodicalSign.ARIES;
        } else if ((mes == Month.APRIL && dia >= 20) || (mes == Month.MAY && dia <= 20)) {
            return ZodicalSign.TAURO;
        } else if ((mes == Month.MAY && dia >= 21) || (mes == Month.JUNE && dia <= 20)) {
            return ZodicalSign.GEMINIS;
        } else if ((mes == Month.JUNE && dia >= 21) || (mes == Month.JULY && dia <= 22)) {
            return ZodicalSign.CANCER;
        } else if ((mes == Month.JULY && dia >= 23) || (mes == Month.AUGUST && dia <= 22)) {
            return ZodicalSign.LEO;
        } else if ((mes == Month.AUGUST && dia >= 23) || (mes == Month.SEPTEMBER && dia <= 22)) {
            return ZodicalSign.VIRGO;
        } else if ((mes == Month.SEPTEMBER && dia >= 23) || (mes == Month.OCTOBER && dia <= 22)) {
            return ZodicalSign.LIBRA;
        } else if ((mes == Month.OCTOBER && dia >= 23) || (mes == Month.NOVEMBER && dia <= 21)) {
            return ZodicalSign.ESCORPIO;
        } else if ((mes == Month.NOVEMBER && dia >= 22) || (mes == Month.DECEMBER && dia <= 21)) {
            return ZodicalSign.SAGITARIO;
        } else if ((mes == Month.DECEMBER && dia >= 22) || (mes == Month.JANUARY && dia <= 19)) {
            return ZodicalSign.CAPRICORNIO;
        } else if ((mes == Month.JANUARY && dia >= 20) || (mes == Month.FEBRUARY && dia <= 18)) {
            return ZodicalSign.ACUARIO;
        } else {
            return ZodicalSign.PISCIS;
        }
    }

}