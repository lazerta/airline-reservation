package com.lei.airlinereservation.exceptions;

public class AuthorizationException extends RuntimeException {
    public AuthorizationException(String msg) {
        super(msg);
    }

    public static AuthorizationException create(String msg){
        return  new AuthorizationException(msg);
    }
    public static AuthorizationException create(){
        return new AuthorizationException("Not authorized");
    }

}
