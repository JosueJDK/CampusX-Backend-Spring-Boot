package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence;

import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.mappers.UserMapper;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserEntity save(User user) {
        return userRepository.save(userMapper.toEntity(user));
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<UserEntity> findByUserName(String userName){
        return userRepository.findByUsername(userName);
    }

    @Override
    public Optional<UserEntity> findByEmailOrUsername(String email, String username) {
        return userRepository.findByEmailOrUsername(email, username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByUserName(String userName) {
        return userRepository.existsByUsername(userName);
    }
    
}
