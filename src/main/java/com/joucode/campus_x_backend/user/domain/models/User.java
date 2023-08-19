package com.joucode.campus_x_backend.user.domain.models;

import com.joucode.campus_x_backend.user_profile.domain.models.UserProfile;
import com.joucode.campus_x_backend.user.domain.enums.ActivityStatusName;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    private Integer incorrectLoginCounter;

    private LocalDateTime createdAt;

    private boolean verifiedAccount;

    private ActivityStatusName activityStatus;

    private boolean isBlocked;

    private boolean isBanned;

    private UserProfile userProfile;

    private Set<Role> roles;

}
