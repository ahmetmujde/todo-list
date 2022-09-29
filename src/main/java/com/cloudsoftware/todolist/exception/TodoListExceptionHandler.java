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
    public ErrorResponse<Object> handleNewPasswordMustBeDifferentLastFivePasswordException(NewPasswordMustBeDifferentLastFivePasswordException newPasswordMustBeDifferentLastFivePasswordException) {
        String errorMessage = newPasswordMustBeDifferentLastFivePasswordException.getMessage();

        return new ErrorResponse<>(errorMessage);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ToDoListCannotBeNullException.class)
    public ErrorResponse<Object> handleToDoListCannotBeNull(ToDoListCannotBeNullException toDoListCannotBeNullException) {
        String errorMessage = toDoListCannotBeNullException.getMessage();

        return new ErrorResponse<>(errorMessage);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ContentCannotBeNullException.class)
    public ErrorResponse<Object> handleContentNotBeNull(ContentCannotBeNullException contentCannotBeNullException) {
        String errorMessage = contentCannotBeNullException.getMessage();

        return new ErrorResponse<>(errorMessage);
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ToDoListNotFoundException.class)
    public ErrorResponse<Object> handleListNotFoundException(ToDoListNotFoundException toDoListNotFoundException) {
        String errorMessage = toDoListNotFoundException.getMessage();

        return new ErrorResponse<>(errorMessage);
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = NoMatchAListByIdException.class)
    public ErrorResponse<Object> handleNoMatchAListById(NoMatchAListByIdException noMatchAListByIdException) {
        String errorMessage = noMatchAListByIdException.getMessage();

        return new ErrorResponse<>(errorMessage);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ToDoListItemCannotBeNullException.class)
    public ErrorResponse<Object> handleToDoListItemCannotBeNull(ToDoListItemCannotBeNullException toDoListItemCannotBeNullException) {
        String errorMessage = toDoListItemCannotBeNullException.getMessage();

        return new ErrorResponse<>(errorMessage);
    }



    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = NoMatchingWithAnyToDoListException.class)
    public ErrorResponse<Object> handleNoMatchingWithAnyToDoListException(NoMatchingWithAnyToDoListException noMatchingWithAnyToDoListException) {
        String errorMessage = noMatchingWithAnyToDoListException.getMessage();

        return new ErrorResponse<>(errorMessage);
    }
}
