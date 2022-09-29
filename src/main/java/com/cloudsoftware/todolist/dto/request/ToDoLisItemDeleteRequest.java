package com.cloudsoftware.todolist.dto.request;

public class ToDoLisItemDeleteRequest {
    private Long toDoListId;
    private Long toDOListItemId;

    public Long getToDoListId() {
        return toDoListId;
    }

    public void setToDoListId(Long toDoListId) {
        this.toDoListId = toDoListId;
    }

    public Long getToDOListItemId() {
        return toDOListItemId;
    }

    public void setToDOListItemId(Long toDOListItemId) {
        this.toDOListItemId = toDOListItemId;
    }
}
