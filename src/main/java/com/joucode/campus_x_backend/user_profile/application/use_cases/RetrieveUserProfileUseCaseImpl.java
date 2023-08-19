package com.joucode.campus_x_backend.user_profile.application.use_cases;

import com.joucode.campus_x_backend.common.exceptions.NotFoundException;
import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;
import com.joucode.campus_x_backend.user_profile.domain.ports.input.RetrieveUserProfileUseCase;
import com.joucode.campus_x_backend.user_profile.domain.ports.output.UserProfileRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RetrieveUserProfileUseCaseImpl implements RetrieveUserProfileUseCase {

    private final UserProfileRepositoryPort repositoryPort;

    @Override
    public UserProfile findById(Long id) {
        return repositoryPort.findById(id).orElseThrow(
                () -> new NotFoundException("El perfil no existe")
        );
    }
}
