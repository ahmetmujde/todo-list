package com.cloudsoftware.todolist.service;

import com.cloudsoftware.todolist.dto.request.ToDoListCreateRequest;
import com.cloudsoftware.todolist.entity.Member;
import com.cloudsoftware.todolist.entity.ToDoList;
import com.cloudsoftware.todolist.exception.ContentCannotBeNull;
import com.cloudsoftware.todolist.exception.ToDoListCannotBeNull;
import com.cloudsoftware.todolist.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;
    private final MemberService memberService;
    private final ToDoListItemService toDoListItemService;

    public ToDoListService(ToDoListRepository toDoListRepository, MemberService memberService, ToDoListItemService toDoListItemService) {
        this.toDoListRepository = toDoListRepository;
        this.memberService = memberService;
        this.toDoListItemService = toDoListItemService;
    }

    public void createToDoList(Long memberId, ToDoListCreateRequest toDoListCreateRequest) {

        Member member = memberService.getMember(memberId);

        if (Objects.isNull(toDoListCreateRequest.getToDoListName())){
            throw new ToDoListCannotBeNull();
        }

        if (Objects.isNull(toDoListCreateRequest.getToDoListItems())){
            throw new ContentCannotBeNull();
        }

        ToDoList toDoList = toDoListRepository.save(ToDoList.createToDoList(toDoListCreateRequest.getToDoListName(), member));

        toDoListCreateRequest.getToDoListItems().forEach(content -> toDoListItemService.createToDoListItem(toDoList, content));
    }
}
