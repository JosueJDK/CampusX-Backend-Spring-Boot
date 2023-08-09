package com.joucode.campus_x_backend.auth.application.services;

import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.mappers.UserMapper;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher emailMatcher = pattern.matcher(login);
        UserEntity userEntity;

        if (emailMatcher.matches()) {
            userEntity = userRepository.findByEmail(login)
                    .orElseThrow(() -> new UsernameNotFoundException("Not Found user with this email: " + login));
        }else {
            userEntity = userRepository.findByUsername(login)
                    .orElseThrow(() -> new UsernameNotFoundException("Not Found user with this username: " + login));
        }

        return  UserDetailsImpl.build(userEntity);

    }


}
