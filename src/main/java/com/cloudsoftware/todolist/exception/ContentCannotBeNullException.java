package com.cloudsoftware.todolist.exception;

public class ContentCannotBeNullException extends RuntimeException {
    public ContentCannotBeNullException() {
        super("Content cannot be null");
    }
}
