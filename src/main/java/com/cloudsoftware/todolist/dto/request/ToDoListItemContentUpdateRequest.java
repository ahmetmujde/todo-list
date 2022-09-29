package com.cloudsoftware.todolist.dto.request;

public class ToDoListItemContentUpdateRequest {
    private Long toDoListId;
    private Long toDoListItemId;
    private String newContent;

    public Long getToDoListId() {
        return toDoListId;
    }

    public void setToDoListId(Long toDoListId) {
        this.toDoListId = toDoListId;
    }

    public Long getToDoListItemId() {
        return toDoListItemId;
    }

    public void setToDoListItemId(Long toDoListItemId) {
        this.toDoListItemId = toDoListItemId;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }
}
