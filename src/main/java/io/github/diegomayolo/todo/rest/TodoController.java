package io.github.diegomayolo.todo.rest;

import io.github.diegomayolo.todo.model.Todo;
import io.github.diegomayolo.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:4200")
public class TodoController
{
    @Autowired
    private TodoRepository repository;

    /**
     * save
     *
     * @param todo Todo
     * @return Todo
     */
    @PostMapping
    public Todo save( @RequestBody Todo todo )
    {
        return repository.save( todo );
    }

    /**
     * getAll
     *
     * @return List<Todo>
     */
    @GetMapping
    public List<Todo> getAll()
    {
        return repository.findAll();
    }

    /**
     * getById
     *
     * @param id Long
     * @return Todo
     */
    @GetMapping("{id}")
    public Todo getById( @PathVariable Long id )
    {
        return repository.findById( id ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND) );
    }
}