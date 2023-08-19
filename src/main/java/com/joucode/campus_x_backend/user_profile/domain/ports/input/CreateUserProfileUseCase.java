package com.joucode.campus_x_backend.user_profile.domain.ports.input;

import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;

public interface CreateUserProfileUseCase {

    UserProfile save(UserProfile userProfile);

}
