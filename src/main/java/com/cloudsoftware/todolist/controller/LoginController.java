package com.cloudsoftware.todolist.controller;

import com.cloudsoftware.todolist.dto.request.LoginRequest;
import com.cloudsoftware.todolist.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void login(@RequestBody LoginRequest loginRequest){
        loginService.memberLogin(loginRequest);
    }
}
