package com.piyapatproject.todo.service;

import com.piyapatproject.todo.dto.TodoDto;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);
    TodoDto getTodo(Long id);
}
