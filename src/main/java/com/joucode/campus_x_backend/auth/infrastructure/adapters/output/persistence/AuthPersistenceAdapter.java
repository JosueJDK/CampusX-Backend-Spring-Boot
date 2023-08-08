package com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence;

import com.joucode.campus_x_backend.auth.domain.ports.output.AuthRepositoryPort;
import com.joucode.campus_x_backend.auth.infrastructure.adapters.output.persistence.mappers.AuthMapper;
import com.joucode.campus_x_backend.user.domain.models.User;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository.UserRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class AuthPersistenceAdapter implements AuthRepositoryPort {

    private final UserRepository authRepository;
    private final AuthMapper authMapper;

    @Override
    public UserEntity save(User user) {
        return authRepository.save(authMapper.toEntity(user));
    }

    @Override
    public Optional<UserEntity> findByEmail(String email){
        return Optional.ofNullable(authRepository.findByEmail(email));
    }

    @Override
    public Optional<UserEntity> findByUserName(String user_name){
        return Optional.ofNullable(authRepository.findByUserName(user_name));
    }

    @Override
    public Boolean existsByEmail(String email) {
        return authRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByUserName(String userName) {
        return authRepository.existsByUserName(userName);
    }
}
