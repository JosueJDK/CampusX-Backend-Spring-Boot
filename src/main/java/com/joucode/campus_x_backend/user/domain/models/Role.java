package com.joucode.campus_x_backend.user.domain.models;

import com.joucode.campus_x_backend.user.domain.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Long roleId;

    private RoleName name;

    public String getName() {
        return name.toString();
    }

}
