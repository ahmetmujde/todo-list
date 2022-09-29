package com.cloudsoftware.todolist.exception;

public class NoMatchingWithAnyToDoListException extends RuntimeException {

    public NoMatchingWithAnyToDoListException() {
        super("No matching with any to-do list!");
    }
}
