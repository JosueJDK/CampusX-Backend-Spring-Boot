package com.joucode.campus_x_backend.common.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Response<T> {

    private Integer code;

    private String status;

    private T data;

}
