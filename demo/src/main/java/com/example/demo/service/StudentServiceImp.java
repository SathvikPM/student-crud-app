package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return  studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(long id) {
       return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(long id) {
        Student student=studentRepository.findById(id).orElse(null);
        if(student==null){
            return null;
        }
        student.setName("rakesh");
        student.setAge(24);
        student.setAddress("Chikamnglur");
        student.setPhoneNo("9876543210");
        return studentRepository.save(student);
    }
}
