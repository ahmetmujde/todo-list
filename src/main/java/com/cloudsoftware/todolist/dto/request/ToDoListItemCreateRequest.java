package com.cloudsoftware.todolist.dto.request;

import java.util.List;

public class ToDoListItemCreateRequest {
    private Long toDoListId;
    private List<String> toDoListItems;

    public Long getToDoListId() {
        return toDoListId;
    }

    public void setToDoListId(Long toDoListId) {
        this.toDoListId = toDoListId;
    }

    public List<String> getToDoListItems() {
        return toDoListItems;
    }

    public void setToDoListItems(List<String> toDoListItems) {
        this.toDoListItems = toDoListItems;
    }
}
