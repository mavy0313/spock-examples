package com.mavy0313.spock.spockexamples;

public class CustomException extends RuntimeException {
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }
}
