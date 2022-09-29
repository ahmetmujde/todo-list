package com.cloudsoftware.todolist.dto.request;

public class ToDoLisItemContentsReadRequest {
    private Long toDoListId;

    public Long getToDoListId() {
        return toDoListId;
    }

    public void setToDoListId(Long toDoListId) {
        this.toDoListId = toDoListId;
    }
}
