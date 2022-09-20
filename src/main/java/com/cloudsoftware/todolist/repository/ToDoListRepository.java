package com.cloudsoftware.todolist.repository;

import com.cloudsoftware.todolist.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

}
