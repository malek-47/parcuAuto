package com.example.ParcAuto.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice(annotations= RestController.class)
@EnableWebMvc
public class RestExceptionHandler {

    @ExceptionHandler(value = ObjectNotFoundException.class)
    public ResponseEntity<Object> handleObjectNotFound(ObjectNotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiException exception = ApiException.builder()
                .statusCode(notFound)
                .description(e.getMessage())
                .build();
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
