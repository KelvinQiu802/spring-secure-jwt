package com.example.springsecurejwtv2.exception;

import com.example.springsecurejwtv2.model.ExceptionResponse;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ExceptionResponse> handleJwtException(JwtException e, HttpServletRequest
            request) {
        ExceptionResponse response = ExceptionResponse.builder()
                .message(e.getMessage())
                .path(request.getRequestURI())
                .status(HttpStatus.UNAUTHORIZED.value())
                .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(response);
    }

}