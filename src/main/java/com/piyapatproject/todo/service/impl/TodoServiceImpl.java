package com.piyapatproject.todo.service.impl;

import com.piyapatproject.todo.dto.TodoDto;
import com.piyapatproject.todo.entity.Todo;
import com.piyapatproject.todo.exception.ResourceNotFoundException;
import com.piyapatproject.todo.repository.TodoRepository;
import com.piyapatproject.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        // Convert TodoDto into TodoJpa entity
        Todo todo = modelMapper.map(todoDto, Todo.class);

        // save this jpa entity to database.
        Todo savedTodo = todoRepository.save(todo);

        // Convert saved TodoJpa entity object into TodoDto object
        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);

        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id:" + id));

        return modelMapper.map(todo, TodoDto.class);
    }
}
