package com.malarcondev.todolist.mapper;

import com.malarcondev.todolist.dto.TaskDTO;
import com.malarcondev.todolist.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskMapper {
    List<TaskDTO> toDtoList(List<TaskEntity> entity);

    TaskDTO toDto(TaskEntity entity);

    TaskEntity toEntity(TaskDTO dto);
}
