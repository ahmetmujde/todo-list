package com.cloudsoftware.todolist.exception;

public class ToDoListCannotBeNull extends RuntimeException{
    public ToDoListCannotBeNull() {
        super("To do list cannot be null");
    }
}
