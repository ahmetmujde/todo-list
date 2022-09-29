package com.cloudsoftware.todolist.exception;

public class NoMatchAListByIdException extends RuntimeException {

    public NoMatchAListByIdException() {
        super("No match a list by id!");
    }
}
