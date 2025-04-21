package com.piyapatproject.todo.controller;

import com.piyapatproject.todo.dto.TodoDto;
import com.piyapatproject.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    // Build Add Todo REST API
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Build Get Todo REST API
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId) {
        TodoDto todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    // Build Get All Todo REST API
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodo() {
       List<TodoDto> todos = todoService.getAllTodos();
       return new ResponseEntity<>(todos, HttpStatus.OK);
//       return ResponseEntity.ok(todos); <<<<=== We can also either use this return statement.
    }

    // Build Update Todo REST API
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId) {
       TodoDto updatedTodoDto = todoService.updateTodo(todoDto, todoId);
       return new ResponseEntity<>(updatedTodoDto, HttpStatus.OK);
    }

    // Build Delete Todo REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId) {
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>("Todo deleted successfully!.", HttpStatus.OK);
    }

    // Build Complete Todo REST API
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId) {
       TodoDto updatedTodoDto = todoService.completeTodo(todoId);
       return new ResponseEntity<>(updatedTodoDto, HttpStatus.OK);
    }

    // Build Incomplete Todo REST API
    @PatchMapping("{id}/incomplete")
    public ResponseEntity<TodoDto> incompleteTodo(@PathVariable("id") Long todoId) {
        TodoDto updatedTodo = todoService.incompleteTodo(todoId);
        return new ResponseEntity<>(updatedTodo,HttpStatus.OK);
    }
}
