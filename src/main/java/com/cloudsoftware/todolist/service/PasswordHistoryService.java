package com.cloudsoftware.todolist.service;

import com.cloudsoftware.todolist.entity.Member;
import com.cloudsoftware.todolist.entity.PasswordHistory;
import com.cloudsoftware.todolist.exception.NewPasswordMustBeDifferentLastFivePasswordException;
import com.cloudsoftware.todolist.repository.PasswordHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasswordHistoryService {

    private final PasswordHistoryRepository passwordHistoryRepository;

    public PasswordHistoryService(PasswordHistoryRepository passwordHistoryRepository) {
        this.passwordHistoryRepository = passwordHistoryRepository;
    }

    public void addNewRecordToPasswordHistory(Member member) {
        PasswordHistory passwordHistory = PasswordHistory.create(member);
        passwordHistoryRepository.save(passwordHistory);
    }

    public void validatePasswordNotEqualsLastFivePassword(Long memberId, String newPassword) {
        List<String> totalEqualPasswords = passwordHistoryRepository.getLastFivePassword(memberId).stream()
                .filter(oldPassword -> oldPassword.equals(newPassword))
                .collect(Collectors.toList());

        if (!totalEqualPasswords.isEmpty()) {
            throw new NewPasswordMustBeDifferentLastFivePasswordException();
        }
    }
}
