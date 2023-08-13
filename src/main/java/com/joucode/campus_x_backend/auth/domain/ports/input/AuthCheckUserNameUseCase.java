package com.joucode.campus_x_backend.auth.domain.ports.input;

public interface AuthCheckUserNameUseCase {
    Boolean checkAvailableUserName(String userName);

}
