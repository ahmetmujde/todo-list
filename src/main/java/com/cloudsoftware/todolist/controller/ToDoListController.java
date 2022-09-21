package com.cloudsoftware.todolist.controller;


import com.cloudsoftware.todolist.dto.request.ToDoListCreateRequest;
import com.cloudsoftware.todolist.dto.request.ToDoListUpdateNameRequest;
import com.cloudsoftware.todolist.dto.response.ToDoListUpdateNameResponse;
import com.cloudsoftware.todolist.service.ToDoListService;
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
@RequestMapping("todolist")
public class ToDoListController {
    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping("/{memberId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createToDOList(@PathVariable("memberId") Long memberId, @RequestBody ToDoListCreateRequest toDoListCreateRequest) {
        toDoListService.createToDoList(memberId, toDoListCreateRequest);
    }

    @PatchMapping("/{memberId}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ToDoListUpdateNameResponse updateToDoListName(@PathVariable("memberId") Long memberId, @RequestBody ToDoListUpdateNameRequest toDoListUpdateNameRequest) {
        return toDoListService.updateToDoListName(memberId, toDoListUpdateNameRequest);
    }

}
