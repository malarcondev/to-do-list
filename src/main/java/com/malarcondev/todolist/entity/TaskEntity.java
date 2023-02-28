package com.malarcondev.todolist.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class TaskEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date = LocalDateTime.now();
}
