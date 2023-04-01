package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.model.Student;
import com.vsu.education.springeducation.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.getStudent();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
