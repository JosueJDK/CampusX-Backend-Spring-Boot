package com.joucode.campus_x_backend.auth.application.services;

import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepositoryPort userRepositoryPort;

    private final ModelMapper mapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher emailMatcher = pattern.matcher(login);
        User user;

        if (emailMatcher.matches()) {
            user = mapper.map(userRepositoryPort.findByEmail(login).orElseThrow(
                    () -> new UsernameNotFoundException("Not Found user with this email: " + login)
            ), User.class);
        }else {
            user = mapper.map(userRepositoryPort.findByUsername(login).orElseThrow(
                    () -> new UsernameNotFoundException("Not Found user with this username: " + login)
            ), User.class);
        }

        return  UserDetailsImpl.build(user);

    }


}
