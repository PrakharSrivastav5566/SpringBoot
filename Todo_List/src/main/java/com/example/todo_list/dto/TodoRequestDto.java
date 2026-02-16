package com.example.todo_list.dto;

import jakarta.validation.constraints.NotBlank;

public record TodoRequestDto(
        @NotBlank(message = "Title is required")
        String title,

        String description,

        boolean status,

        @NotBlank(message = "User ID is required")
        String userId
) {}