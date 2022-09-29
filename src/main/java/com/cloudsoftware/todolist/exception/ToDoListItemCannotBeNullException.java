package com.cloudsoftware.todolist.exception;

public class ToDoListItemCannotBeNullException extends RuntimeException {
    public ToDoListItemCannotBeNullException() {
        super("To do list's Items cannot be null");
    }
}
