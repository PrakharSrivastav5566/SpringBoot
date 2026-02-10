package com.example.day3sms.controller;

import java.util.List;

import com.example.day3sms.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.day3sms.dto.StudentRequestDto;
import com.example.day3sms.dto.StudentResponseDto;
import com.example.day3sms.service.StudentService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService service;
    private final JwtUtil jwtutil;

    public StudentController(StudentService service, JwtUtil jwtutil) {
        this.service = service;
        this.jwtutil = jwtutil;
    }

    // 🔹 CREATE
    @PostMapping("/students")
    public ResponseEntity<StudentResponseDto> createStudent(
            @Valid @RequestBody StudentRequestDto student) {

        return ResponseEntity.status(201)
                .body(service.addStudent(student));
    }

    // 🔹 GET ALL
    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {

        return ResponseEntity.ok(service.getAllStudents());
    }

    // 🔹 GET BY ID
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(
            @PathVariable String id) {

        return ResponseEntity.ok(service.getStudentById(id));
    }

    // 🔹 UPDATE
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(
            @PathVariable String id,
            @Valid @RequestBody StudentRequestDto student) {

        return ResponseEntity.ok(service.updateStudent(id, student));
    }

    // 🔹 DELETE
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable String id) {

        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
