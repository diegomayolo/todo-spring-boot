package io.github.diegomayolo.todo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Todo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Column
    private Boolean done;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime doneDate;
}
