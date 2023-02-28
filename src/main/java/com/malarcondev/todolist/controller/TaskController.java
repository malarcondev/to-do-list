package com.malarcondev.todolist.controller;

import com.malarcondev.todolist.dto.TaskDTO;
import com.malarcondev.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tasks")
@CrossOrigin("*")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDTO> findAllTasks(){
        return taskService.findAllTasks();
    }
}
