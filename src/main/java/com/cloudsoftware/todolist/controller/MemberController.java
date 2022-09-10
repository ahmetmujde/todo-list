package com.cloudsoftware.todolist.controller;


import com.cloudsoftware.todolist.dto.request.MemberCreateRequest;
import com.cloudsoftware.todolist.dto.request.MemberCurrentPasswordChangeRequest;
import com.cloudsoftware.todolist.dto.request.MemberUsernameUpdateRequest;
import com.cloudsoftware.todolist.dto.response.MemberCreateResponse;
import com.cloudsoftware.todolist.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    public MemberCreateResponse create(@RequestBody MemberCreateRequest memberCreateRequest) {
        return memberService.create(memberCreateRequest);
    }

    @PatchMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateMemberName(@PathVariable("id") Long id, @RequestBody MemberUsernameUpdateRequest memberUsernameUpdateRequest) {
        memberService.updateMemberName(id, memberUsernameUpdateRequest);
    }

    @PatchMapping("/password/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void memberCurrentPasswordChange(@PathVariable("id") Long id, @RequestBody MemberCurrentPasswordChangeRequest memberCurrentPasswordChangeRequest) {
        memberService.memberCurrentPasswordChange(id, memberCurrentPasswordChangeRequest);
    }
}
