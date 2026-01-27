package com.example.day3sms.controller;

import com.example.day3sms.model.StudentModel;
import com.example.day3sms.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // create function API
    @PostMapping("add-student/")
    public StudentModel addStudent(@RequestBody StudentModel student) {
        return service.addStudent(student);
    }


    @GetMapping("/students")
    public List<StudentModel> getStudent(){
        return service.getStudent();
    }

    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
    }
}
