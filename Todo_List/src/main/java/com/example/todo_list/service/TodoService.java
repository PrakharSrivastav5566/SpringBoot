package com.example.todo_list.service;

import com.example.todo_list.dto.TodoRequestDto;
import com.example.todo_list.dto.TodoResponseDto;
import com.example.todo_list.model.TodoModel;
import com.example.todo_list.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoResponseDto> getTodosByUser(String userId) {
        return todoRepository.findByUserId(userId).stream()
                .map(todo -> new TodoResponseDto(
                        todo.getId(),
                        todo.getTitle(),
                        todo.getDescription(),
                        todo.isStatus(),
                        todo.getUserId()
                ))
                .collect(Collectors.toList());
    }

    public TodoResponseDto createTodo(TodoRequestDto request) {
        TodoModel todo = new TodoModel();
        todo.setTitle(request.title());
        todo.setDescription(request.description());
        todo.setStatus(request.status());
        todo.setUserId(request.userId());

        TodoModel savedTodo = todoRepository.save(todo);
        return new TodoResponseDto(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getDescription(),
                savedTodo.isStatus(),
                savedTodo.getUserId()
        );
    }
}
