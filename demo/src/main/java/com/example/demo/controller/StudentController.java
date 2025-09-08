package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

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

    @GetMapping
    public  ResponseEntity<List<Student>> getAllStudents(){
        List<Student> Students=studentService.getAllStudents();
        return  ResponseEntity.ok(Students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id){
        Student student=studentService.getStudent(id);
        if(student==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable  long id){
        Student updatedStudent=studentService.updateStudent(id);
        return ResponseEntity.ok(updatedStudent);
    }


}
