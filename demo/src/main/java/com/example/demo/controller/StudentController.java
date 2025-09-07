package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student saved=studentService.addStudent(student);
        return ResponseEntity.status(200).body(saved);
    }


}
