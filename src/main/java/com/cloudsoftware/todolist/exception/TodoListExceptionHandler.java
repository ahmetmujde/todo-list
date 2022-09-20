package com.cloudsoftware.todolist.exception;

import com.cloudsoftware.todolist.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TodoListExceptionHandler {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = PasswordNotValidException.class)
    public ErrorResponse<List<String>> handlePasswordNotValidException(PasswordNotValidException passwordNotValidException) {
        String errorMessage = passwordNotValidException.getMessage();
        List<String> errorDetails = passwordNotValidException.getErrors();

        return new ErrorResponse<>(errorMessage, errorDetails);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MemberUsernameValidationException.class)
    public ErrorResponse<Object> handleMemberUsernameValidationException(MemberUsernameValidationException memberUsernameValidationException) {
        String errorMessage = memberUsernameValidationException.getMessage();

        return new ErrorResponse<>(errorMessage);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MemberNotFoundException.class)
    public ErrorResponse<Object> handleMemberNotFoundException(MemberNotFoundException memberNotFoundException) {
        String errorMessage = memberNotFoundException.getMessage();

        return new ErrorResponse<>(errorMessage);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MemberPasswordNotEqualsException.class)
    public ErrorResponse<Object> handleMemberPasswordNotEqualsException(MemberPasswordNotEqualsException memberPasswordNotEqualsException) {
        String errorMessage = memberPasswordNotEqualsException.getMessage();

        return new ErrorResponse<>(errorMessage);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = NewPasswordMustBeDifferentLastFivePasswordException.class)
    public ErrorResponse<Object> handleContentNotBeNull(NewPasswordMustBeDifferentLastFivePasswordException newPasswordMustBeDifferentLastFivePasswordException) {
        String errorMessage = newPasswordMustBeDifferentLastFivePasswordException.getMessage();

        return new ErrorResponse<>(errorMessage);
    }
}
