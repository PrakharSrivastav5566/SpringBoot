package com.example.todo_list.dto;

public record TodoResponseDto(String id, String title, String description, boolean status, String userId) {}
