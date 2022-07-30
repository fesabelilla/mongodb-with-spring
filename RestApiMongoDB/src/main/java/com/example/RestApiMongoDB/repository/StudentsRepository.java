package com.example.RestApiMongoDB.repository;

import com.example.RestApiMongoDB.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentsRepository extends MongoRepository<Student, String> {

    Optional<Student> findStudentByEmail(String email);
}
