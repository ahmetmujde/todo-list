package com.cloudsoftware.todolist.dto.request;

public class ToDoListDeleteRequest {
    private Long todoListId;

    public Long getTodoListId() {
        return todoListId;
    }

    public void setTodoListId(Long todoListId) {
        this.todoListId = todoListId;
    }
}
