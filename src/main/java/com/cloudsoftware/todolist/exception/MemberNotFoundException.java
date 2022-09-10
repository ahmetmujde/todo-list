package com.cloudsoftware.todolist.exception;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException() {
        super("İslem yapmak istediginiz kullanıcı bulunamadi");
    }
}
