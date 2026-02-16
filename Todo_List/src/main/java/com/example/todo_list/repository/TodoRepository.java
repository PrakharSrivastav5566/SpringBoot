package com.example.todo_list.repository;

import com.example.todo_list.model.TodoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends MongoRepository<TodoModel, String> {
    List<TodoModel> findByUserId(String userId);

    Optional<TodoModel> findByIdAndUserId(String id, String userId);
}
