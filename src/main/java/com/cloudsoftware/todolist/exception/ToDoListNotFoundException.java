package com.cloudsoftware.todolist.exception;

public class ToDoListNotFoundException extends RuntimeException {

    public ToDoListNotFoundException() {
        super("İslem yapmak istediginiz to do list bulunamadi");
    }
}
