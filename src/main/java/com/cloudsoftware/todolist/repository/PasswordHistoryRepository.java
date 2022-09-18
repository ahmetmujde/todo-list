package com.cloudsoftware.todolist.repository;

import com.cloudsoftware.todolist.entity.PasswordHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, Long> {

    @Query(value = "SELECT password  FROM password_history where member_id = ?1 order by created_date DESC limit 5", nativeQuery = true)
    List<String> getLastFivePassword(Long id);

}
