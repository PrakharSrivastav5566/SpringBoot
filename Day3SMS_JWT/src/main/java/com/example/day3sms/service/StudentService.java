package com.example.day3sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day3sms.dto.StudentRequestDto;
import com.example.day3sms.dto.StudentResponseDto;
import com.example.day3sms.exception.StudentNotFoundException;
import com.example.day3sms.model.StudentModel;
import com.example.day3sms.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    private StudentResponseDto toResponseDto(StudentModel student) {
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail()
        );
    }

    private StudentModel toEntity(StudentRequestDto dto) {
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        return student;
    }

    public StudentResponseDto addStudent(StudentRequestDto dto) {

        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        StudentModel saved = repository.save(toEntity(dto));
        return toResponseDto(saved);
    }

    public List<StudentResponseDto> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public StudentResponseDto getStudentById(String id) {
        return repository.findById(id)
                .map(this::toResponseDto)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {

        StudentModel student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        return toResponseDto(repository.save(student));
    }

    public void deleteStudent(String id) {
        StudentModel student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        repository.delete(student);
    }
}
