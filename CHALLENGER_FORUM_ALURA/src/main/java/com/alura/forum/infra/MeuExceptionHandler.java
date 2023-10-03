package com.alura.forum.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MeuExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity notFoundError() {
        return ResponseEntity.notFound().build();
    }

    private record DadosArgumentNotValid(String field, String mesage) {
        public DadosArgumentNotValid(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity argumentNotValid(MethodArgumentNotValidException e) {
        var exceptions = e.getFieldErrors();
        return ResponseEntity.badRequest().body(exceptions.stream().map(DadosArgumentNotValid::new).toList());
    }

}
