package com.example.RestApiMongoDB.controller;

import com.example.RestApiMongoDB.facility.StudentsFacility;
import com.example.RestApiMongoDB.models.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("app/v1/students")
public class StudentController {

    private final StudentsFacility studentsFacility;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentsFacility.getAllStudents();
    }

}
