package com.cloudsoftware.todolist.service;

import com.cloudsoftware.todolist.dto.request.ToDoLisItemContentsReadRequest;
import com.cloudsoftware.todolist.dto.request.ToDoLisItemDeleteRequest;
import com.cloudsoftware.todolist.dto.request.ToDoListItemCreateRequest;
import com.cloudsoftware.todolist.dto.request.ToDoListItemContentUpdateRequest;
import com.cloudsoftware.todolist.dto.response.ReadToDoListItemContentsResponse;
import com.cloudsoftware.todolist.dto.response.ToDoListItemContentUpdateResponse;
import com.cloudsoftware.todolist.entity.ToDoList;
import com.cloudsoftware.todolist.entity.ToDoListItem;
import com.cloudsoftware.todolist.exception.NoMatchingWithAnyToDoListException;
import com.cloudsoftware.todolist.exception.ToDoListItemCannotBeNullException;
import com.cloudsoftware.todolist.repository.ToDoListItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ToDoListItemService {
    private final ToDoListItemRepository toDoListItemRepository;
    private final ToDoListService toDoListService;
    private final MemberService memberService;

    public ToDoListItemService(ToDoListItemRepository toDoListItemRepository, ToDoListService toDoListService, MemberService memberService) {
        this.toDoListItemRepository = toDoListItemRepository;
        this.toDoListService = toDoListService;
        this.memberService = memberService;
    }

    public void createToDoListItem(Long memberId, ToDoListItemCreateRequest toDoListItemCreateRequest) {
        memberService.isValidMember(memberId);
        Optional<ToDoList> toDoList = toDoListService.getToDoListById(memberId,toDoListItemCreateRequest.getToDoListId());

        if ((Objects.isNull(toDoListItemCreateRequest.getToDoListItems())) || (toDoListItemCreateRequest.getToDoListItems().size() == 0)) {
            throw new ToDoListItemCannotBeNullException();
        }

        toDoListItemCreateRequest.getToDoListItems()
                .forEach(content -> toDoListItemRepository.save(ToDoListItem.createToDoListItem(toDoList.get(),content)));
    }


    public ReadToDoListItemContentsResponse readToDoListItemContents(Long memberId, ToDoLisItemContentsReadRequest toDoLisItemContentsReadRequest) {
        memberService.isValidMember(memberId);

        toDoListService.validateToDoListById(memberId, toDoLisItemContentsReadRequest.getToDoListId());

        Long toDoListId = toDoLisItemContentsReadRequest.getToDoListId();

        List<String> toDoListItemContents = toDoListItemRepository.readToDoListItemContents(memberId,toDoListId);

        return new ReadToDoListItemContentsResponse(toDoListItemContents);
    }


    public ToDoListItemContentUpdateResponse updateToDoListItemContent(Long memberId, ToDoListItemContentUpdateRequest toDoListItemContentUpdateRequest) {

        Long toDoListId = toDoListItemContentUpdateRequest.getToDoListId();
        Long toDoListItemId = toDoListItemContentUpdateRequest.getToDoListItemId();
        String newContent = toDoListItemContentUpdateRequest.getNewContent();
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

        toDoListService.validateToDoListById(memberId, toDoListId);

        toDoListItemRepository.updateToDoListContent(newContent, toDoListId, toDoListItemId, timestamp);

        String toDoListName = toDoListService.getToDoListNameByIdById(memberId, toDoListId);
        String content = getContentById(memberId,toDoListId,toDoListItemId);

        return new ToDoListItemContentUpdateResponse(toDoListName,content);
    }

    public void deleteToDoListItem(Long memberId, ToDoLisItemDeleteRequest toDoLisItemDeleteRequest) {
        Long toDoListId = toDoLisItemDeleteRequest.getToDoListId();
        Long toDoListItemId = toDoLisItemDeleteRequest.getToDOListItemId();

        memberService.isValidMember(memberId);

        toDoListService.validateToDoListById(memberId, toDoListId);

        validateToDoListItem(toDoListId,toDoListItemId);

        toDoListItemRepository.deleteById(toDoListItemId);
    }


    public String getContentById(Long memberId, Long toDoListId, Long toDoListItemId) {
        return toDoListItemRepository.getToDoListItemContent(memberId, toDoListId, toDoListItemId);
    }


    private void validateToDoListItem(Long toDoListId, Long toDoListItemId) {

        if (!toDoListItemRepository.validateToDoListItem(toDoListId, toDoListItemId)) {
            throw new NoMatchingWithAnyToDoListException();
        }

    }

}
