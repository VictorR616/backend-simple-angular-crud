package com.victorrojas.backend_simple_angular_crud.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message, Long id) {
        super(message + " with id: " + id);
    }
}
