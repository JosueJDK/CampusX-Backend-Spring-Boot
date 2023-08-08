package com.joucode.campus_x_backend.auth.domain.ports.input;

public interface AuthCheckAvailableEmailUseCase {
    Boolean checkAvailableEmail(String email);

}
