package com.cloudsoftware.todolist.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

public class ErrorResponse<T> {

    private String errorMessage;

    @JsonInclude(NON_NULL)
    private T errorDetail;

    public ErrorResponse(String errorMessage, T errorDetail) {
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(T errorDetail) {
        this.errorDetail = errorDetail;
    }

}
