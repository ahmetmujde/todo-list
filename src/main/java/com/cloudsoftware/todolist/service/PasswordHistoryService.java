package com.cloudsoftware.todolist.service;

import com.cloudsoftware.todolist.entity.Member;
import com.cloudsoftware.todolist.entity.PasswordHistory;
import com.cloudsoftware.todolist.repository.PasswordHistoryRepository;
import org.springframework.stereotype.Service;

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
}
