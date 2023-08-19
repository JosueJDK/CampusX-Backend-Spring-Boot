package com.joucode.campus_x_backend.user_profile.application.use_cases;

import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;
import com.joucode.campus_x_backend.user_profile.domain.ports.input.CreateUserProfileUseCase;
import com.joucode.campus_x_backend.user_profile.domain.ports.output.UserProfileRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUserProfileUseCaseImpl implements CreateUserProfileUseCase {

    private final UserProfileRepositoryPort repositoryPort;

    @Override
    public UserProfile save(UserProfile userProfile) {
        return repositoryPort.save(userProfile);
    }
}
