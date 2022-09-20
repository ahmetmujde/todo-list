package com.cloudsoftware.todolist.dto.request;

import java.util.List;

public class ToDoListCreateRequest {
    private String toDoListName;
    private List<String> toDoListItems;

    public String getToDoListName() {
        return toDoListName;
    }

    public void setToDoListName(String toDoListName) {
        this.toDoListName = toDoListName;
    }

    public List<String> getToDoListItems() {
        return toDoListItems;
    }

    public void setToDoListItems(List<String> toDoListItems) {
        this.toDoListItems = toDoListItems;
    }
}
