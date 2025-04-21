package com.piyapatproject.todo.service;

import com.piyapatproject.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);
    TodoDto getTodo(Long id);
    List<TodoDto> getAllTodos();
}
