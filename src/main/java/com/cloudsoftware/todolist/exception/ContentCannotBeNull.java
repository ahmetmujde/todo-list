package com.cloudsoftware.todolist.exception;

public class ContentCannotBeNull extends RuntimeException{
    public ContentCannotBeNull() {
        super("Content cannot be null");
    }
}
