package com.cloudsoftware.todolist.controller;


import com.cloudsoftware.todolist.dto.request.ToDoLisItemContentsReadRequest;
import com.cloudsoftware.todolist.dto.request.ToDoLisItemDeleteRequest;
import com.cloudsoftware.todolist.dto.request.ToDoListItemCreateRequest;
import com.cloudsoftware.todolist.dto.request.ToDoListItemContentUpdateRequest;
import com.cloudsoftware.todolist.dto.response.ReadToDoListItemContentsResponse;
import com.cloudsoftware.todolist.dto.response.ToDoListItemContentUpdateResponse;
import com.cloudsoftware.todolist.service.ToDoListItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Items")
public class ToDoListItemController {
    private final ToDoListItemService toDoListItemService;

    public ToDoListItemController(ToDoListItemService toDoListItemService) {
        this.toDoListItemService = toDoListItemService;
    }

    @PostMapping("/{memberId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createToDoListItem(@PathVariable("memberId") Long memberId, @RequestBody ToDoListItemCreateRequest toDoListItemCreateRequest) {
        toDoListItemService.createToDoListItem(memberId, toDoListItemCreateRequest);
    }

    @ResponseBody
    @GetMapping("/{memberId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ReadToDoListItemContentsResponse readToDoList(@PathVariable("memberId") Long memberId, @RequestBody ToDoLisItemContentsReadRequest toDoLisItemContentsReadRequest) {
        return toDoListItemService.readToDoListItemContents(memberId, toDoLisItemContentsReadRequest);
    }

    @ResponseBody
    @PatchMapping("/{memberId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ToDoListItemContentUpdateResponse updateToDoListItemContent(@PathVariable("memberId") Long memberId, @RequestBody ToDoListItemContentUpdateRequest toDoListItemContentUpdateRequest) {
       return toDoListItemService.updateToDoListItemContent(memberId, toDoListItemContentUpdateRequest);
    }

    @DeleteMapping("/{memberId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteToDoListItem(@PathVariable("memberId") Long memberId, @RequestBody ToDoLisItemDeleteRequest toDoLisItemDeleteRequest) {
        toDoListItemService.deleteToDoListItem(memberId, toDoLisItemDeleteRequest);
    }


}
