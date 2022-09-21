package com.cloudsoftware.todolist.service;

import com.cloudsoftware.todolist.dto.request.LoginRequest;
import com.cloudsoftware.todolist.entity.Login;
import com.cloudsoftware.todolist.entity.Member;
import com.cloudsoftware.todolist.exception.MemberNotFoundException;
import com.cloudsoftware.todolist.repository.LoginRepository;
import com.cloudsoftware.todolist.repository.MemberRepository;
import com.cloudsoftware.todolist.util.PasswordHashUtil;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {
    private final LoginRepository loginRepository;
    private final MemberRepository memberRepository;

    public LoginService(LoginRepository loginRepository, MemberRepository memberRepository) {
        this.loginRepository = loginRepository;
        this.memberRepository = memberRepository;
    }

    public void memberLogin(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        password = PasswordHashUtil.sha512(password);

        // todo kullanıcının şifresi doğru değilse ona göre exception gönder
        Member member = memberRepository.getWithUsernameAndPassword(username, password);

        if (Objects.isNull(member)) {
            throw new MemberNotFoundException();
        }

        loginRepository.save(new Login().create(member));
    }
}
