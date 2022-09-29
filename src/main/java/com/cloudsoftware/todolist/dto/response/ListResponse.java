package com.cloudsoftware.todolist.dto.response;

import java.util.List;

public class ListResponse {

    private long listId;

    private String listName;

    private List<String> listItems;

    public long getListId() {
        return listId;
    }

    public void setListId(long listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<String> getListItems() {
        return listItems;
    }

    public void setListItems(List<String> listItems) {
        this.listItems = listItems;
    }
}
