package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.respository;

import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
    UserEntity findByUserName(String userName);
    Boolean existsByEmail(String email);
    Boolean existsByUserName(String User_name);

}
