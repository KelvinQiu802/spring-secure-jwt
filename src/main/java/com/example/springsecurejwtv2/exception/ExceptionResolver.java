package com.example.springsecurejwtv2.exception;

import com.example.springsecurejwtv2.model.ExceptionResponse;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log
public class ExceptionResolver {

    @ExceptionHandler(value = {
            JwtException.class,
            UsernameNotFoundException.class,
            AuthenticationException.class,
    })
    public ResponseEntity<ExceptionResponse> handleUnauthorized(Exception e, HttpServletRequest
            request) {
        log.warning(e.getClass().toString());
        ExceptionResponse response = ExceptionResponse.builder()
                .message(e.getMessage())
                .path(request.getRequestURI())
                .status(HttpStatus.UNAUTHORIZED.value())
                .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(response);
    }

}
