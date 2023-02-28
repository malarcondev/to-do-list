package com.malarcondev.todolist.service;

import com.malarcondev.todolist.dto.TaskDTO;
import com.malarcondev.todolist.entity.TaskEntity;
import com.malarcondev.todolist.mapper.TaskMapper;
import com.malarcondev.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TaskService {
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    public List<TaskDTO> findAllTasks(){
        return taskMapper.toDtoList(taskRepository.findAll());
    }

    public TaskDTO saveTask(TaskDTO body) throws Exception {
        TaskEntity entity = Optional.ofNullable(body)
                .filter(e -> StringUtils.isNotBlank(e.getTitle()))
                .map(taskMapper::toEntity)
                .orElseThrow(() -> new Exception("el titulo es requerido"));

        TaskEntity save = taskRepository.save(entity);
        return taskMapper.toDto(save);
    }

    public TaskDTO updateTask(TaskDTO body) throws Exception {
        TaskEntity entity = Optional.ofNullable(body)
                .filter(e -> StringUtils.isNotBlank(e.getTitle()))
                .map(taskMapper::toEntity)
                .orElseThrow(() -> new Exception("el titulo es requerido"));

        Optional<TaskEntity> taskEntityOpt = taskRepository.findById(entity.getId());
        if (taskEntityOpt.isPresent()){
            TaskEntity saved = taskRepository.save(entity);
            return taskMapper.toDto(saved);
        } else {
           throw new Exception("Tarea no encontrado");
        }
    }
}
