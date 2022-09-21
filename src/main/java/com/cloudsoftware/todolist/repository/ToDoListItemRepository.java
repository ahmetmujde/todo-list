package com.cloudsoftware.todolist.repository;

import com.cloudsoftware.todolist.entity.ToDoListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListItemRepository extends JpaRepository<ToDoListItem, Long> {

}
