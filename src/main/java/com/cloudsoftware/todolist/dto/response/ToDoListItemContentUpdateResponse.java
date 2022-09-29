package com.cloudsoftware.todolist.dto.response;

public class ToDoListItemContentUpdateResponse {
    private String toDoListName;
    private String newContent;

    public ToDoListItemContentUpdateResponse(String toDoListName, String newContent) {
        this.toDoListName = toDoListName;
        this.newContent = newContent;
    }

    public String getToDoListName() {
        return toDoListName;
    }

    public void setToDoListName(String toDoListName) {
        this.toDoListName = toDoListName;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }
}
