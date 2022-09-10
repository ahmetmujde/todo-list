package com.cloudsoftware.todolist.controller;

import com.cloudsoftware.todolist.dto.response.PasswordRuleResponse;
import com.cloudsoftware.todolist.service.PasswordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("password")
public class PasswordRestController {

    private final PasswordService passwordService;

    public PasswordRestController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("rules")
    public PasswordRuleResponse getRules() {
        return passwordService.getAllPasswordRules();
    }
}
