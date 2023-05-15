package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.model.StudentEntity;
import com.vsu.education.springeducation.data.model.StudentWithCourseEntity;
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
    public ResponseEntity<StudentWithCourseEntity> addStudent(@RequestBody StudentWithCourseEntity studentWithCourseEntity) {
        studentService.addStudent(studentWithCourseEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<StudentEntity>> getStudents() {
        List<StudentEntity> studentEntities = studentService.getStudents();
        return new ResponseEntity<>(studentEntities, HttpStatus.OK);
    }
}
