package com.cloudsoftware.todolist.dto.response;

public class ToDoListUpdateNameResponse {
    private String toDoListName;

    public ToDoListUpdateNameResponse(String toDoListName) {
        this.toDoListName = toDoListName;
    }

    public String getToDoListName() {
        return toDoListName;
    }

    public void setToDoListName(String toDoListName) {
        this.toDoListName = toDoListName;
    }

}
