package com.cloudsoftware.todolist.repository;

import com.cloudsoftware.todolist.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update todo_list set todo_list_name = ?2 where member_id = ?1 and todo_list.id = ?3", nativeQuery = true)
    void updateToDoListName(Long memberId, String toDoListName, Long todoListId);
}
