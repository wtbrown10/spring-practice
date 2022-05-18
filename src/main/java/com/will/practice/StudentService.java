package com.will.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email is taken my guy");
        }

         studentRepository.save(student);
        System.out.println( student.getFirstName() + " student added");
    }

    public void deleteStudent(Long studentId){
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exist!");
        }
        studentRepository.deleteById(studentId);
        System.out.println("Student was successfully deleted!");
    }
}
