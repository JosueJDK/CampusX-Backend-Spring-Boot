package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence;

import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.domain.ports.output.UserRepositoryPort;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.mappers.UserMapper;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public User save(User user) {
        return userMapper.toUser(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        return userEntityOptional.map(userMapper::toUser);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userMapper.toUserList(userEntities);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(email);
        return userEntityOptional.map(userMapper::toUser);
    }

    @Override
    public Optional<User> findByUsername(String userName){
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(userName);
        return userEntityOptional.map(userMapper::toUser);
    }

    @Override
    public Optional<User> findByEmailOrUsername(String email, String username) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmailOrUsername(email, username);
        return userEntityOptional.map(userMapper::toUser);
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
