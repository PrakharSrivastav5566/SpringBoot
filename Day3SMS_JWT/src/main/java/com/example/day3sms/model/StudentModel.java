package com.example.day3sms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class StudentModel extends UserModel {

    @Id
    private String id;

    private String name;

    private int age;

    private String email;
}
