package com.joucode.campus_x_backend.user.domain.models;

import com.joucode.campus_x_backend.user.infrastructure.adapters.output.persistence.entity.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Integer roleId;

    private RoleName name;

    public String getName() {
        return name.toString();
    }

}
