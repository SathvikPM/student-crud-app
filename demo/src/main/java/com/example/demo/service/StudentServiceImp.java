package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.dto.StudentUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Student updateStudent(long id, Student studentDetails) {
      Student student=studentRepository.findById(id).orElse(null);
      student.setName(studentDetails.getName());
      student.setAge(studentDetails.getAge());
      student.setAddress(studentDetails.getAddress());
      student.setPhoneNo(studentDetails.getPhoneNo());
      student.setBranch(student.getBranch());
      studentRepository.save(student);
      return  student;
    }

    @Override
    public Student partailUpdateStudent(long id, StudentUpdateDTO updates) {
        Student  student=studentRepository.findById(id).orElse(null);
        if(student==null){
            return null;
        }
        if(updates.getName()!=null){
            student.setName(updates.getName());
        }
        if(updates.getAge()!=null){
            student.setAge(updates.getAge());
        }
        if(updates.getAddress()!=null){
            student.setAddress(updates.getAddress());
        }
        if(updates.getBranch()!=null){
            student.setBranch(updates.getBranch());
        }
        if(updates.getPhoneNo()!=null){
            student.setPhoneNo(updates.getPhoneNo());
        }
        return studentRepository.save(student);
    }

    @Override
    public Student deleteStudent(long id) {
        Student student=studentRepository.findById(id).orElse(null);
        if(student==null){
          return  null;
        }
        studentRepository.delete(student);
        return student;

    }
}
