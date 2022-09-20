package com.cloudsoftware.todolist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy="memberId")
    private Set<ToDoList> ToDoList;

    public Member() {
    }

    public Member(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Member create(String username, String password) {
        return new Member(username, password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<com.cloudsoftware.todolist.entity.ToDoList> getToDoList() {
        return ToDoList;
    }

    public void setToDoList(Set<com.cloudsoftware.todolist.entity.ToDoList> toDoList) {
        ToDoList = toDoList;
    }
}
