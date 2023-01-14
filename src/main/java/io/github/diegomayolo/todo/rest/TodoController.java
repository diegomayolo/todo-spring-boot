package io.github.diegomayolo.todo.rest;

import io.github.diegomayolo.todo.model.Todo;
import io.github.diegomayolo.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:4200")
public class TodoController
{
    @PostMapping
    public Todo save( @RequestBody Todo todo )
    {
        return repository.save( todo );
    }

    @Autowired
    private TodoRepository repository;

    public
    @GetMapping("{id}") Todo getById( @PathVariable Long id )
    {
        return repository.findById( id ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND) );
    }
}