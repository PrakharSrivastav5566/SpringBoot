package com.example.todo_list.controller;

import com.example.todo_list.dto.TodoRequestDto;
import com.example.todo_list.dto.TodoResponseDto;
import com.example.todo_list.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{userId}")
    public List<TodoResponseDto> getTodosByUser(@PathVariable String userId) {
        return todoService.getTodosByUser(userId);
    }

    @PostMapping
    public TodoResponseDto createTodo(@Valid @RequestBody TodoRequestDto request) {
        return todoService.createTodo(request);
    }

    @PutMapping("/{todoId}")
    public TodoResponseDto updateTodo(
            @PathVariable String todoId,
            @Valid @RequestBody TodoRequestDto request
    ) {
        return todoService.updateTodo(todoId, request);
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable String todoId, @RequestParam String userId) {
        todoService.deleteTodo(todoId, userId);
    }
}
