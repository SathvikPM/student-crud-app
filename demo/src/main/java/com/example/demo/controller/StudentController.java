package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.example.demo.dto.StudentUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student studentDerails){
        Student updatedstudent=studentService.updateStudent(id,studentDerails);
        return ResponseEntity.ok(updatedstudent);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Student> partailUpdateStudent(@PathVariable long id, @RequestBody StudentUpdateDTO updates){
        Student student=studentService.partailUpdateStudent(id,updates);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long id){
        Student student=studentService.deleteStudent(id);
        return  ResponseEntity.ok(student);

    }






}
