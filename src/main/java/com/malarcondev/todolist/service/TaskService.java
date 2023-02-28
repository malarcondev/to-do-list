package com.malarcondev.todolist.service;

import com.malarcondev.todolist.dto.TaskDTO;
import com.malarcondev.todolist.mapper.TaskMapper;
import com.malarcondev.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    public List<TaskDTO> findAllTasks(){
        return taskMapper.toDto(taskRepository.findAll());
    }
}
