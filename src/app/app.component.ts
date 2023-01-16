import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms'
import {TodoService} from "./todo.service";
import Todo from "./todo";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit
{
  todos: Todo[] = [];

  form: FormGroup = new FormGroup( {
    description : new FormControl( '' )
  } );

  /**
   *
   * @param service TodoService
   */
  constructor( private service:TodoService ){}

  /**
   * ngOnInit
   *
   */
  ngOnInit()
  {
    this.listTodos();
  }

  /**
   * listTodos
   *
   */
  listTodos()
  {
    this.service.listTodos().subscribe( todoList =>
    {
      this.todos = todoList
    } );
  }

  /**
   * submit
   *
   */
  submit()
  {
    const todo: Todo = { ...this.form.value }
    this.service.save( todo ).subscribe( savedTodo =>
    {
      this.todos.push( savedTodo );
      this.form.reset();
    } );
  }
}
