package com.joucode.campus_x_backend.user_profile.domain.ports.input;

import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;

public interface RetrieveUserProfileUseCase {

    UserProfile findById(Long id);

}
