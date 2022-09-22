package com.cloudsoftware.todolist.dto.response;

import java.util.List;

public class ReadToDoListResponse {
    private List<String> toDoList;

    public ReadToDoListResponse(List<String> toDoList) {
        this.toDoList = toDoList;
    }

    public List<String> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<String> toDoList) {
        this.toDoList = toDoList;
    }
}
