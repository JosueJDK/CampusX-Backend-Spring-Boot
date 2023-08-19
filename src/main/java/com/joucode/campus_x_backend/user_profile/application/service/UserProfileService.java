package com.joucode.campus_x_backend.user_profile.application.service;

import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;
import com.joucode.campus_x_backend.user_profile.domain.ports.input.CreateUserProfileUseCase;
import com.joucode.campus_x_backend.user_profile.domain.ports.input.RetrieveUserProfileUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserProfileService implements
        CreateUserProfileUseCase,
        RetrieveUserProfileUseCase {

    private final CreateUserProfileUseCase createUserProfile;

    private final RetrieveUserProfileUseCase retrieveUserProfile;


    @Override
    public UserProfile save(UserProfile userProfile) {
        return createUserProfile.save(userProfile);
    }

    @Override
    public UserProfile findById(Long id) {
        return retrieveUserProfile.findById(id);
    }

}
