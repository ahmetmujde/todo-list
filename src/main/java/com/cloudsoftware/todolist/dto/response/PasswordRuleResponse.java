package com.cloudsoftware.todolist.dto.response;

import java.util.List;

public class PasswordRuleResponse {

    private final String title;
    private final List<String> rules;

    private PasswordRuleResponse(String title, List<String> rules) {
        this.title = title;
        this.rules = rules;
    }

    public static PasswordRuleResponse create(String title, List<String> rules) {
        return new PasswordRuleResponse(title, rules);
    }

    public String getTitle() {
        return title;
    }

    public List<String> getRules() {
        return rules;
    }
}
