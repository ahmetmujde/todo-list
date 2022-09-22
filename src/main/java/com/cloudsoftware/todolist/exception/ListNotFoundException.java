package com.cloudsoftware.todolist.exception;

public class ListNotFoundException extends RuntimeException {

    public ListNotFoundException() {
        super("İslem yapmak istediginiz to do list bulunamadi");
    }
}
