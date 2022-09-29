package com.cloudsoftware.todolist.repository;

import com.cloudsoftware.todolist.entity.ToDoListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoListItemRepository extends JpaRepository<ToDoListItem, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update todo_list_item set content = ?1, updated_date = ?4 where todo_list_id = ?2 and todo_list_item.id = ?3", nativeQuery = true)
    void updateToDoListContent(String newContent, Long toDoListId, Long todoListItemId, Date updatedDate);

    @Query(value = "select content from todo_list_item as tli inner join todo_list tl on tl.id = tli.todo_list_id " +
            "where tl.member_id = ?1 and tli.todo_list_id = ?2 and tli.id = ?3", nativeQuery = true)
    String getToDoListItemContent(Long memberId, Long toDoListId, Long toDoListItemId);

    @Query(value = "select content from todo_list_item as tli inner join todo_list tl on tl.id = tli.todo_list_id " +
            "where tl.member_id = ?1 and tli.todo_list_id = ?2", nativeQuery = true)
    List <String> readToDoListItemContents(Long memberId, Long toDoListId);

    @Query(value = "select count(*) > 0 from todo_list_item where todo_list_id = ?1 and id = ?2 ", nativeQuery = true)
    Boolean validateToDoListItem(Long toDoListId, Long toDoListItemId);

}
