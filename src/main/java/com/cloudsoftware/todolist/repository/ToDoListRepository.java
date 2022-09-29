package com.cloudsoftware.todolist.repository;

import com.cloudsoftware.todolist.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update todo_list set todo_list_name = ?2, updated_date = ?4 where member_id = ?1 and todo_list.id = ?3", nativeQuery = true)
    void updateToDoListName(Long memberId, String toDoListName, Long todoListId, Date updatedDate);

    @Query(value = "select todo_list_name from todo_list where member_id = ?1", nativeQuery = true)
    List <String> readToDoLists(Long memberId);

    @Query(value = "select count(*) > 0 from todo_list where member_id = ?1 and todo_list.id = ?2", nativeQuery = true)
    boolean checkListById(Long memberId, Long toDoListId);

    @Query(value = "select * from todo_list where member_id = ?1 and todo_list.id = ?2", nativeQuery = true)
    ToDoList getToDoListById(Long memberId, Long toDoListId);

    @Query(value = "select todo_list_name from todo_list where member_id = ?1 and todo_list.id = ?2", nativeQuery = true)
    String getToDoListNameByIdById(Long memberId, Long toDoListId);
}
