package com.example.day2part2.controller;

import com.example.day2part2.model.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Home {
    @GetMapping("/")
//    public StudentModel getStudent() {
//        StudentModel student = new StudentModel(1, "Prakhar", "ps@gmail.com");
//        return student;
//    }

    public ArrayList<StudentModel> getStudent() {

        ArrayList<StudentModel> al = new ArrayList<>();
        al.add(new StudentModel(1, "Prakhar", "ps@gmail.com"));
        al.add(new StudentModel(2, "Shukla", "as@gmail.com"));
        al.add(new StudentModel(3, "Moksh", "mu@gmail.com"));

        return al;
    }
}
