package com.example.ParcAuto.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiException {
    private HttpStatus statusCode;
    private String description;
}
