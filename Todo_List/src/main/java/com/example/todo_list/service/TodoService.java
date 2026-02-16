package com.example.todo_list.service;

import com.example.todo_list.dto.TodoRequestDto;
import com.example.todo_list.dto.TodoResponseDto;
import com.example.todo_list.model.TodoModel;
import com.example.todo_list.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TodoResponseDto createTodo(TodoRequestDto request) {
        TodoModel todo = new TodoModel();
        todo.setTitle(request.title());
        todo.setDescription(request.description());
        todo.setStatus(request.status());
        todo.setUserId(request.userId());

        TodoModel savedTodo = todoRepository.save(todo);
        return toResponse(savedTodo);
    }

    public TodoResponseDto updateTodo(String todoId, TodoRequestDto request) {
        TodoModel existingTodo = todoRepository.findByIdAndUserId(todoId, request.userId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found"));

        existingTodo.setTitle(request.title());
        existingTodo.setDescription(request.description());
        existingTodo.setStatus(request.status());

        TodoModel savedTodo = todoRepository.save(existingTodo);
        return toResponse(savedTodo);
    }

    public void deleteTodo(String todoId, String userId) {
        TodoModel existingTodo = todoRepository.findByIdAndUserId(todoId, userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found"));

        todoRepository.delete(existingTodo);
    }

    private TodoResponseDto toResponse(TodoModel todo) {
        return new TodoResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isStatus(),
                todo.getUserId()
        );
    }
}
