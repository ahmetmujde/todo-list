package com.cloudsoftware.todolist.service;

import com.cloudsoftware.todolist.dto.request.ToDoListCreateRequest;
import com.cloudsoftware.todolist.dto.request.ToDoListDeleteRequest;
import com.cloudsoftware.todolist.dto.request.ToDoListUpdateNameRequest;
import com.cloudsoftware.todolist.dto.response.ReadToDoListResponse;
import com.cloudsoftware.todolist.dto.response.ToDoListUpdateNameResponse;
import com.cloudsoftware.todolist.entity.Member;
import com.cloudsoftware.todolist.entity.ToDoList;
import com.cloudsoftware.todolist.exception.NoMatchAListById;
import com.cloudsoftware.todolist.exception.ToDoListCannotBeNull;
import com.cloudsoftware.todolist.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
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

        checkNullableToDoList(toDoListCreateRequest);

        ToDoList toDoList = toDoListRepository.save(ToDoList.createToDoList(toDoListCreateRequest.getToDoListName(), member));

        toDoListCreateRequest.getToDoListItems().forEach(content -> toDoListItemService.createToDoListItem(toDoList, content));
    }

    public ReadToDoListResponse readToDoList(Long memberId) {
        memberService.isValidMember(memberId);

        List<String> toDoListsNames = toDoListRepository.readToDoLists(memberId);
        return new  ReadToDoListResponse(toDoListsNames);
    }

    public ToDoListUpdateNameResponse updateToDoListName(Long memberId, ToDoListUpdateNameRequest toDoListUpdateNameRequest) {
        memberService.isValidMember(memberId);

        toDoListRepository.updateToDoListName(
                memberId,
                toDoListUpdateNameRequest.getToDoListName(),
                toDoListUpdateNameRequest.getTodoListId(),
                Timestamp.valueOf(LocalDateTime.now()));

        return new ToDoListUpdateNameResponse(toDoListUpdateNameRequest.getToDoListName());
    }

    public void deleteToDoList(Long memberId, ToDoListDeleteRequest toDoListDeleteRequest) {
        Long todoListId = toDoListDeleteRequest.getTodoListId();

        memberService.isValidMember(memberId);

        boolean checkListById = toDoListRepository.checkListById(memberId, todoListId);

        if (!checkListById) {
            throw new NoMatchAListById();
        }

        toDoListRepository.deleteById(todoListId);
    }

    private void checkNullableToDoList(ToDoListCreateRequest toDoListCreateRequest) {
        if (Objects.isNull(toDoListCreateRequest.getToDoListName())) {
            throw new ToDoListCannotBeNull();
        }

        if ((Objects.isNull(toDoListCreateRequest.getToDoListItems())) || (toDoListCreateRequest.getToDoListItems().size() == 0)) {
            throw new ToDoListCannotBeNull();
        }
    }
}
