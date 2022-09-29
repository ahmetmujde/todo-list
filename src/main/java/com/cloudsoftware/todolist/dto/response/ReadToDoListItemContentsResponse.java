package com.cloudsoftware.todolist.dto.response;

import java.util.List;

public class ReadToDoListItemContentsResponse {
    private List<String> toDoListItemContents;

    public ReadToDoListItemContentsResponse(List<String> toDoListItemContents) {
        this.toDoListItemContents = toDoListItemContents;
    }

    public List<String> getToDoListItemContents() {
        return toDoListItemContents;
    }

    public void setToDoListItemContents(List<String> toDoListItemContents) {
        this.toDoListItemContents = toDoListItemContents;
    }
}
