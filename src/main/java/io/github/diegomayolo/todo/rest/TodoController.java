package io.github.diegomayolo.todo.rest;

import io.github.diegomayolo.todo.model.Todo;
import io.github.diegomayolo.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
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

    /**
     * delete
     *
     * @param id Long
     */
    @DeleteMapping( "{id}" )
    public void delete( @PathVariable Long id )
    {
        repository.deleteById( id );
    }

    /**
     * doneTodo
     *
     * @param id Long
     * @return Todo
     */
    @PatchMapping( "{id}/done" )
    public Todo doneTodo( @PathVariable Long id )
    {
        return repository.findById( id ).map( todo ->
        {
            todo.setDone( true );
            todo.setDoneDate( LocalDateTime.now() );
            repository.save( todo );
            return todo;
        } ).orElse( null );
    }
}