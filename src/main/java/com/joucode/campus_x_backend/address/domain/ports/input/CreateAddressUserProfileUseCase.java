package com.joucode.campus_x_backend.address.domain.ports.input;

import com.joucode.campus_x_backend.address.domain.models.Address;
import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;

public interface CreateAddressUserProfileUseCase {

    UserProfile save(Long userProfileId, Address address);

}
