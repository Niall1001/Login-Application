package com.niallwalters.loginapp.exception;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            ResourceNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleNotFoundException(final Exception exception) {
        return ExceptionBuilder.buildErrorResponseRepresentation(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler({
            ExpiredJwtException.class})
    public ResponseEntity<ErrorResponse> handleExpiredJTWException(final Exception exception) {
        return ExceptionBuilder.buildErrorResponseRepresentation(HttpStatus.FORBIDDEN, exception.getMessage());
    }

    @ExceptionHandler({
            UnauthorizedException.class})
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(final Exception exception) {
        return ExceptionBuilder.buildErrorResponseRepresentation(HttpStatus.FORBIDDEN, exception.getMessage());
    }
}
