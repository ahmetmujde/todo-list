package com.cloudsoftware.todolist.repository;

import com.cloudsoftware.todolist.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "SELECT count(*) > 0 FROM member where username = ?1", nativeQuery = true)
    boolean existByUsername(String username);

    @Query(value = "SELECT count(*) > 0 FROM member where id = ?1", nativeQuery = true)
    boolean existById(Long id);

    @Query(value = "SELECT password FROM Member where id = ?1", nativeQuery = true)
    String getPasswordById(Long id);

    @Query(value = "UPDATE member SET username = ?2 WHERE id = ?1", nativeQuery = true)
    void updateUsernameById(Long id, String username);

    @Modifying
    @Query(value = "UPDATE member SET password = ?2 WHERE id = ?1", nativeQuery = true)
    void updatePassword(Long id, String newPassword);

    @Query(value = "SELECT * FROM member where username = ?1 and password = ?2", nativeQuery = true)
    Member getWithUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM member where id = ?1", nativeQuery = true)
    Member getMemberById(Long id);
}
