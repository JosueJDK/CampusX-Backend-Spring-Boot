package com.joucode.campus_x_backend.common.exceptions;

import com.joucode.campus_x_backend.common.response.Response;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;
import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class BaseExceptionController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Response> handleNotFoundException(NoHandlerFoundException ex, HttpServletRequest request) {
        String requestedUrl = request.getRequestURL().toString();
        Response response = new Response(NOT_FOUND.value(), NOT_FOUND.name(), Map.of("error", Map.of("path", requestedUrl)));
        return new ResponseEntity<>(response, NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleValidateExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        Response response = new Response(UNPROCESSABLE_ENTITY.value(), UNPROCESSABLE_ENTITY.name(), Map.of("error", errors));

        return new ResponseEntity<>(response, UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Response> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String errorMessage = ex.getMostSpecificCause().getMessage();

        int startIndex = errorMessage.indexOf("Key (") + "Key (".length();
        int endIndex = errorMessage.indexOf(")", startIndex);

        String field = errorMessage.substring(startIndex, endIndex).trim();
        String message = errorMessage.substring(errorMessage.indexOf("=") + "=".length()).trim();

        Response response = new Response(CONFLICT.value(), CONFLICT.name(), Map.of("error", Map.of(field, message)));

        return new ResponseEntity<>(response, CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<Response> handleNotFoundException(NotFoundException ex) {
        Response response = new Response(NOT_FOUND.value(), NOT_FOUND.name(), Map.of("error", ex.getMessage()));
        return new ResponseEntity<>(response, NOT_FOUND);
    }

    @ExceptionHandler(CredentialsInvalidException.class)
    private ResponseEntity<Response> handleCredentialsInvalidException(CredentialsInvalidException ex){
        Response response = new Response(UNAUTHORIZED.value(), UNAUTHORIZED.name(), Map.of("error", ex.getMessage()));
        return new ResponseEntity<>(response, UNAUTHORIZED);
    }

    @ExceptionHandler(GlobalException.class)
    private ResponseEntity<Response> handleGlobalException(GlobalException ex){
        Response response = new Response(INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR.name(), Map.of("error", ex.getMessage()));
        return new ResponseEntity<>(response, INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomAuthenticationException.class)
    public ResponseEntity<Object> handleCustomAuthenticationException(CustomAuthenticationException ex) {
        Map<String, Object> body = Map.of(
                "code", UNAUTHORIZED.value(),
                "message", UNAUTHORIZED.getReasonPhrase(),
                "error", ex.getMessage()
        );
        return new ResponseEntity<>(body, UNAUTHORIZED);
    }
}