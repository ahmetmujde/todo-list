package com.cloudsoftware.todolist.exception;

public class NewPasswordMustBeDifferentLastFivePasswordException extends RuntimeException {

    public NewPasswordMustBeDifferentLastFivePasswordException() {
        super("New Password Must Be Different Last Five Password!");
    }

}
