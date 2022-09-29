package com.cloudsoftware.todolist.exception;

public class ToDoListCannotBeNullException extends RuntimeException {
    public ToDoListCannotBeNullException() {
        super("To do list cannot be null");
    }
}
