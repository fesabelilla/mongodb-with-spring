package com.example.RestApiMongoDB.repository;

import com.example.RestApiMongoDB.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentsRepository extends MongoRepository<Student, String> {
}
