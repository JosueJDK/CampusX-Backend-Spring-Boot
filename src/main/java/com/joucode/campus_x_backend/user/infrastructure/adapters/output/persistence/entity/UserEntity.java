package com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity;

import com.joucode.campus_x_backend.profile.infrastructure.adapters.output.persistence.entity.UserProfileEntity;
import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.enums.ActivityStatusName;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "incorrect_login_counter")
    private Integer incorrectLoginCounter;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "verified_account")
    private boolean verifiedAccount;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity_status")
    private ActivityStatusName activityStatus;

    @Column(name = "is_blocked", nullable = false)
    private boolean isBlocked;

    @Column(name = "is_banned", nullable = false)
    private boolean isBanned;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_profile_id", nullable = false)
    private UserProfileEntity userProfileEntity;

    @ManyToMany(fetch = FetchType.LAZY) // Cambia FetchType.LAZY a FetchType.EAGER
    @JoinTable(
            name = "user_role_table",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

    public UserEntity(UserEntity userEntity) {
        this.userId = userEntity.getUserId();
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
        this.email = userEntity.getEmail();
        this.phoneNumber = userEntity.getPhoneNumber();
        this.incorrectLoginCounter = userEntity.getIncorrectLoginCounter();
        this.createdAt = userEntity.getCreatedAt();
        this.verifiedAccount = userEntity.isVerifiedAccount();
        this.activityStatus = userEntity.getActivityStatus();
        this.isBlocked = userEntity.isBlocked();
        this.isBanned = userEntity.isBanned();
        this.userProfileEntity = userEntity.getUserProfileEntity();
        this.roles = userEntity.getRoles();
    }

}
