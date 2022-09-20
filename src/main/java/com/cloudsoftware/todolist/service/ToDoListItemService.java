package com.cloudsoftware.todolist.service;

import com.cloudsoftware.todolist.entity.ToDoList;
import com.cloudsoftware.todolist.entity.ToDoListItem;
import com.cloudsoftware.todolist.repository.ToDoListItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ToDoListItemService {
    private final ToDoListItemRepository toDoListItemRepository;

    public ToDoListItemService(ToDoListItemRepository toDoListItemRepository) {
        this.toDoListItemRepository = toDoListItemRepository;
    }

    public void createToDoListItem(ToDoList toDoList, String content) {
        toDoListItemRepository.save(ToDoListItem.createToDoListItem(toDoList, content));
    }
}
