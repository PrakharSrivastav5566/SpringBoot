package com.example.todo_list.controller;

import com.example.todo_list.dto.TodoRequestDto;
import com.example.todo_list.dto.TodoResponseDto;
import com.example.todo_list.service.TodoService;
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
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto request) {
        return todoService.createTodo(request);
    }
}
