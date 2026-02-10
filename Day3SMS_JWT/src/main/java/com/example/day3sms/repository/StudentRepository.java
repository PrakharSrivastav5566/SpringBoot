package com.example.day3sms.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.day3sms.model.StudentModel;

public interface StudentRepository extends MongoRepository<StudentModel, String> {

    Optional<StudentModel> findByEmail(String email);
}
