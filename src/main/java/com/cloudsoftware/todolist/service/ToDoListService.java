package com.cloudsoftware.todolist.service;

import com.cloudsoftware.todolist.dto.request.ToDoListCreateRequest;
import com.cloudsoftware.todolist.dto.request.ToDoListDeleteRequest;
import com.cloudsoftware.todolist.dto.request.ToDoListUpdateNameRequest;
import com.cloudsoftware.todolist.dto.response.ListResponse;
import com.cloudsoftware.todolist.dto.response.ReadToDoListResponse;
import com.cloudsoftware.todolist.dto.response.ToDoListUpdateNameResponse;
import com.cloudsoftware.todolist.entity.Member;
import com.cloudsoftware.todolist.entity.ToDoList;
import com.cloudsoftware.todolist.entity.ToDoListItem;
import com.cloudsoftware.todolist.exception.ToDoListNotFoundException;
import com.cloudsoftware.todolist.exception.NoMatchAListByIdException;
import com.cloudsoftware.todolist.exception.ToDoListCannotBeNullException;
import com.cloudsoftware.todolist.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;
    private final MemberService memberService;

    public ToDoListService(ToDoListRepository toDoListRepository, MemberService memberService) {
        this.toDoListRepository = toDoListRepository;
        this.memberService = memberService;
    }

    public void createToDoList(Long memberId, ToDoListCreateRequest toDoListCreateRequest) {

        Member member = memberService.getMember(memberId);

        checkNullableToDoList(toDoListCreateRequest);

        toDoListRepository.save(ToDoList.createToDoList(toDoListCreateRequest.getToDoListName(), member));
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
            throw new NoMatchAListByIdException();
        }

        toDoListRepository.deleteById(todoListId);
    }

    private void checkNullableToDoList(ToDoListCreateRequest toDoListCreateRequest) {
        if (Objects.isNull(toDoListCreateRequest.getToDoListName())) {
            throw new ToDoListCannotBeNullException();
        }
    }

    public  Optional<ToDoList> getToDoListById(Long memberId, Long toDoListId) {
       return Optional.ofNullable(toDoListRepository.getToDoListById(memberId, toDoListId));
    }

    public void validateToDoListById(Long memberId, Long toDoListId) {
        if (Objects.isNull(toDoListRepository.getToDoListById(memberId, toDoListId))) {
            throw new ToDoListNotFoundException();
        }
    }

    public String getToDoListNameByIdById(Long memberId, Long toDoListId) {
        if (Objects.isNull(toDoListRepository.getToDoListById(memberId, toDoListId))) {
            throw new ToDoListNotFoundException();
        }

        return toDoListRepository.getToDoListNameByIdById(memberId,toDoListId);
    }


    public List<ListResponse> getAllToDoList(Long memberId) {
        memberService.isValidMember(memberId);

        return toDoListRepository.findAll().stream()
                .map(ToDoListService::getListResponse)
                .collect(Collectors.toList());
    }

    private static ListResponse getListResponse(ToDoList toDoList) {
        ListResponse listResponse = new ListResponse();
        listResponse.setListId(toDoList.getId());
        listResponse.setListName(toDoList.getToDoListName());

        List<ToDoListItem> toDoListItems = toDoList.getToDoListItems();

        List<String> itemNames = toDoListItems.stream()
                .map(ToDoListItem::getContent)
                .collect(Collectors.toList());

        listResponse.setListItems(itemNames);

        return listResponse;
    }
}
