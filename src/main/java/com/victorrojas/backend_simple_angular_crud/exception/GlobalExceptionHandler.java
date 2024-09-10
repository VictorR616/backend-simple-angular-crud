package com.victorrojas.backend_simple_angular_crud.exception;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { ApiRequestException.class })
    public ResponseEntity<ApiException> handleApiRequestException(ApiRequestException ex) {
        ApiException apiException = ApiException.builder()
                .message(ex.getMessage())
                .code(HttpStatus.BAD_REQUEST.value())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .timestamp(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { ResourceNotFoundException.class })
    public ResponseEntity<ApiException> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ApiException apiException = ApiException.builder()
                .message(ex.getMessage())
                .code(HttpStatus.NOT_FOUND.value())
                .httpStatus(HttpStatus.NOT_FOUND)
                .timestamp(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiException> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        ApiException apiException = ApiException.builder()
                .message("Failed to validate request")
                .code(HttpStatus.BAD_REQUEST.value())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .timestamp(ZonedDateTime.now())
                .fields(Optional.of(errors))
                .build();

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

}
