package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence;

import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.mappers.UserMapper;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        userRepository.save(userEntity);
        return userMapper.toUser(userEntity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userMapper.toUser(userRepository.findById(id)));
    }

    @Override
    public List<User> findAll() {
        return Collections.singletonList(userMapper.toUser(userRepository.findAll()));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userMapper.toUser(userRepository.findByEmail(email)));
    }

    @Override
    public Optional<User> findByUserName(String userName){
        return Optional.ofNullable(userMapper.toUser(userRepository.findByUserName(userName)));
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }
}
