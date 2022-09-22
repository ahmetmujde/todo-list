package com.cloudsoftware.todolist.exception;

public class NoMatchAListById extends RuntimeException {

    public NoMatchAListById() {
        super("No match a list by id!");
    }
}
