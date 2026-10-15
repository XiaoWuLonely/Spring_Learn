package edu.baiyun.chapt12;

public class PasswordWrongException extends RuntimeException{
    public PasswordWrongException() {
    }

    public PasswordWrongException(String message) {
        super(message);
    }
}
