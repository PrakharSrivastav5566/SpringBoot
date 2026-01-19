package com.example.day2part2.controller;

import com.example.day2part2.model.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping("/")
    public StudentModel getStudent() {
        StudentModel student = new StudentModel(1, "Prakhar", "ps@gmail.com");
        return student;
    }
}
