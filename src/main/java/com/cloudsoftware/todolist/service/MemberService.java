package com.cloudsoftware.todolist.service;

import com.cloudsoftware.todolist.dto.request.MemberCreateRequest;
import com.cloudsoftware.todolist.dto.request.MemberCurrentPasswordChangeRequest;
import com.cloudsoftware.todolist.dto.request.MemberUsernameUpdateRequest;
import com.cloudsoftware.todolist.dto.response.MemberCreateResponse;
import com.cloudsoftware.todolist.entity.Member;
import com.cloudsoftware.todolist.exception.MemberNotFoundException;
import com.cloudsoftware.todolist.exception.MemberPasswordNotEqualsException;
import com.cloudsoftware.todolist.exception.MemberUsernameValidationException;
import com.cloudsoftware.todolist.repository.MemberRepository;
import com.cloudsoftware.todolist.util.PasswordHashUtil;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class MemberService {

    private final PasswordService passwordService;
    private final PasswordHistoryService passwordHistoryService;
    private final MemberRepository memberRepository;

    public MemberService(PasswordService passwordService, PasswordHistoryService passwordHistoryService, MemberRepository memberRepository) {
        this.passwordService = passwordService;
        this.passwordHistoryService = passwordHistoryService;
        this.memberRepository = memberRepository;
    }

    public MemberCreateResponse create(MemberCreateRequest memberCreateRequest) {
        String username = memberCreateRequest.getUsername();
        String password = memberCreateRequest.getPassword();

        validateUsername(username);

        String hashedPassword = passwordService.createPassword(password);

        Member member = new Member(username, hashedPassword);

        if (memberRepository.existByUsername(username)) {
            throw new MemberUsernameValidationException("Kullanmak istediğiniz username zaten bulunmakta!");
        }

        Member savedMember = memberRepository.save(member);
        passwordHistoryService.addNewRecordToPasswordHistory(savedMember);

        return new MemberCreateResponse(savedMember.getId(), savedMember.getUsername());
    }

    private static void validateUsername(String username) {
        if (Objects.isNull(username)) {
            throw new MemberUsernameValidationException("Username'in değeri null olamaz");
        }

        if (username.length() < 8) {
            throw new MemberUsernameValidationException("Username mimimum sekiz karakterden oluşmalıdır!");
        }

        if (username.contains(" ")) {
            throw new MemberUsernameValidationException("Username boşluk içeremez!");
        }
    }

    public void updateMemberName(Long id, MemberUsernameUpdateRequest memberUsernameUpdateRequest) {
        if (memberRepository.existById(id) && !memberRepository.existByUsername(memberUsernameUpdateRequest.getUsername())) {
            memberRepository.updateUsernameById(id, memberUsernameUpdateRequest.getUsername());
        }
    }

    @Transactional
    public void memberCurrentPasswordChange(Long id, MemberCurrentPasswordChangeRequest memberCurrentPasswordChangeRequest) {
        String currentPassword = PasswordHashUtil.sha512(memberCurrentPasswordChangeRequest.getCurrentPassword());
        String newPassword = memberCurrentPasswordChangeRequest.getNewPassword();
        String currentPasswordFromDatabase = getPassword(id);

        validateCurrentPassword(currentPassword, currentPasswordFromDatabase);

        newPassword = passwordService.createPassword(newPassword);

        passwordHistoryService.validatePasswordNotEqualsLastFivePassword(id,newPassword);

        memberRepository.updatePassword(id, newPassword);

        Member member = memberRepository.findById(id)
                .orElseThrow(MemberNotFoundException::new);

        passwordHistoryService.addNewRecordToPasswordHistory(member);
    }

    private String getPassword(Long id) {
        String password = memberRepository.getPasswordById(id);

        if (Objects.isNull(password)) {
            throw new MemberNotFoundException();
        }

        return password;
    }

    private void validateCurrentPassword(String currentPassword, String currentPasswordFromDB) {
        if (!currentPassword.equals(currentPasswordFromDB)) {
            throw new MemberPasswordNotEqualsException();
        }
    }

    public Member getMember(Long id){
        return  memberRepository.getMemberById(id);
    }
}
