package com.will.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudent(){
        return studentService.getStudent();
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student){
        studentService.postStudents(student);
        System.out.println(student.getId() + " " + student);
    }

    @DeleteMapping
    public void deleteStudent(){
        studentService.
    }

    @PutMapping
    public String updateStudent(){
        return "Student updated";
    }
}
