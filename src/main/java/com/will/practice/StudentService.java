package com.will.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String getStudent(){
        return "this the student foreal this time!";
    }

    public void postStudents(Student student){
         studentRepository.save(student);
        System.out.println( student.getFirstName() + " student added");
    }
}
