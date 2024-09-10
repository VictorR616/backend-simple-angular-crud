package com.victorrojas.backend_simple_angular_crud.exception;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiException {
    private final String message;
    private final int code;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;
    private final Optional<Map<String, String>> fields;
}
