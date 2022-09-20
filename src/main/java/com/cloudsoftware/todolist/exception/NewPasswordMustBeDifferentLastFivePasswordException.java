package com.cloudsoftware.todolist.exception;

import java.util.List;

public class NewPasswordMustBeDifferentLastFivePasswordException extends RuntimeException {

    public NewPasswordMustBeDifferentLastFivePasswordException() {
        super("New Password Must Be Different Last Five Password!");
    }

}
