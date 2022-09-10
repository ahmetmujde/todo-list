package com.cloudsoftware.todolist.exception;

public class MemberPasswordNotEqualsException extends RuntimeException {

    public MemberPasswordNotEqualsException() {
        super("Girilen password ayni degil!");
    }
}
