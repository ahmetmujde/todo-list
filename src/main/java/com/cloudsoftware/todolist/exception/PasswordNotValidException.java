package com.cloudsoftware.todolist.exception;

import java.util.List;

public class PasswordNotValidException extends RuntimeException {

    private final List<String> errors;

    public PasswordNotValidException(List<String> errors) {
        super("Password doğru değil");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
