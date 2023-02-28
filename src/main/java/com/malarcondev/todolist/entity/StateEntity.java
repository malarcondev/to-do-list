package com.malarcondev.todolist.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "staties")
public class StateEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "state")
    private Integer state;
}