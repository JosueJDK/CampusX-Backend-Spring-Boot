package com.joucode.campus_x_backend.auth.domain.ports.input;

public interface AuthCheckEmailUseCase {
    Boolean checkAvailableEmail(String email);

}
