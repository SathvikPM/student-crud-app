package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.dto.StudentUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudent(long id);
    Student updateStudent(long id,Student studentDerails);
    Student partailUpdateStudent(long id, StudentUpdateDTO updates);
    Student deleteStudent(long id);
}
