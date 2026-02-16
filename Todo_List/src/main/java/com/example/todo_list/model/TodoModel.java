package com.example.todo_list.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
@Data
public class TodoModel {

    @Id
    private String id;

    private String title;

    private String description;

    private boolean status;

    private String userId;
}
