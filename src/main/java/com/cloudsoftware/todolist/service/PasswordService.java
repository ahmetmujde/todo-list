package com.cloudsoftware.todolist.service;

import com.cloudsoftware.todolist.constant.PasswordRule;
import com.cloudsoftware.todolist.dto.response.PasswordRuleResponse;
import com.cloudsoftware.todolist.exception.PasswordNotValidException;
import com.cloudsoftware.todolist.util.PasswordHashUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PasswordService {

    private static final String PASSWORD_RULE_TITLE = "Password aşağıdaki kurallara uymalıdır";

    public PasswordRuleResponse getAllPasswordRules() {
        List<String> passwordRules = Stream.of(PasswordRule.values())
                .map(PasswordRule::getDetail)
                .collect(Collectors.toList());

        return PasswordRuleResponse.create(PASSWORD_RULE_TITLE, passwordRules);
    }

    public String createPassword(String password) {
        validatePassword(password);
        return PasswordHashUtil.sha512(password);
    }

    private void validatePassword(String password) {
        List<String> errorDetails = Stream.of(PasswordRule.values())
                .filter(passwordRule -> passwordIsNotValid(password, passwordRule.getRegex()))
                .map(PasswordRule::getDetail)
                .collect(Collectors.toList());

        if (!errorDetails.isEmpty()) {
            throw new PasswordNotValidException(errorDetails);
        }
    }

    private boolean passwordIsNotValid(String password, String regex) {
        return !Pattern.matches(regex, password);
    }
}
