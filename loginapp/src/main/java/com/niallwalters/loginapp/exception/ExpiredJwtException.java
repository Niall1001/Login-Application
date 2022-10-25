package com.niallwalters.loginapp.exception;

public class ExpiredJwtException extends RuntimeException{
    public ExpiredJwtException(final String message){
        super(message);
    }
}
