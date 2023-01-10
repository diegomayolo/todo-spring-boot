package io.github.diegomayolo.todo.repository;

import io.github.diegomayolo.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository
    extends JpaRepository<Todo, Long>
{

}
