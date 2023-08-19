package com.joucode.campus_x_backend.user_profile.domain.ports.output;

import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserProfileRepositoryPort {

    UserProfile save(UserProfile userProfile);

    Optional<UserProfile> findById(Long id);

    List<UserProfile> findAll();

}
