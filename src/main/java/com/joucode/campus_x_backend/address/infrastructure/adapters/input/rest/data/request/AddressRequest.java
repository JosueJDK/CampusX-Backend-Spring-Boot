package com.joucode.campus_x_backend.address.infrastructure.adapters.input.rest.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {


    private Long country;

    private Long city;

    private Long province;

    private Long district;

}
