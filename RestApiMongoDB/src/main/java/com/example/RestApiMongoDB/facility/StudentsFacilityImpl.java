package com.example.RestApiMongoDB.facility;

import com.example.RestApiMongoDB.models.Student;
import com.example.RestApiMongoDB.repository.StudentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentsFacilityImpl implements StudentsFacility{

    private final StudentsRepository studentsRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }
}
