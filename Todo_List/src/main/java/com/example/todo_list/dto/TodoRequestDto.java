package com.example.todo_list.dto;

public record TodoRequestDto(String title, String description, boolean status, String userId) {}
