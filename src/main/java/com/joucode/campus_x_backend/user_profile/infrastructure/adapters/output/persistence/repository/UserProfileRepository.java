package com.joucode.campus_x_backend.user_profile.infrastructure.adapters.output.persistence.repository;

import com.joucode.campus_x_backend.user_profile.infrastructure.adapters.output.persistence.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
}
