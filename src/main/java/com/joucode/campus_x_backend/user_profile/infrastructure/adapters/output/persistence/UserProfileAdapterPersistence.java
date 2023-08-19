package com.joucode.campus_x_backend.user_profile.infrastructure.adapters.output.persistence;

import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;
import com.joucode.campus_x_backend.user_profile.domain.ports.output.UserProfileRepositoryPort;
import com.joucode.campus_x_backend.user_profile.infrastructure.adapters.output.persistence.entity.UserProfileEntity;
import com.joucode.campus_x_backend.user_profile.infrastructure.adapters.output.persistence.mappers.UserProfileMapper;
import com.joucode.campus_x_backend.user_profile.infrastructure.adapters.output.persistence.repository.UserProfileRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserProfileAdapterPersistence implements UserProfileRepositoryPort {

    private final UserProfileRepository repository;

    private final UserProfileMapper mapper;

    @Override
    public UserProfile save(UserProfile userProfile) {
        return mapper.toModel(repository.save(mapper.toEntity(userProfile)));
    }

    @Override
    public Optional<UserProfile> findById(Long id) {
        Optional<UserProfileEntity> userProfile = repository.findById(id);
        return userProfile.map(mapper::toModel);
    }

    @Override
    public List<UserProfile> findAll() {
        return null;
    }
}
