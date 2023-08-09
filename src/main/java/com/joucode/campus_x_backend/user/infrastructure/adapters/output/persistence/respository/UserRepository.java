package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository;

import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUsername(String userName);

    Optional<UserEntity> findByEmailOrUsername(String email, String username);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String User_name);

}
