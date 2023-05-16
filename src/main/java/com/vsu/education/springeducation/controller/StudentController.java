package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.dto.request.StudentRequest;
import com.vsu.education.springeducation.data.dto.response.StudentResponse;
import com.vsu.education.springeducation.data.entity.StudentEntity;
import com.vsu.education.springeducation.data.domain.Student;
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
    public ResponseEntity<Object> addStudent(@RequestBody StudentRequest request) {
        studentService.addStudent(new StudentEntity(
                0,
                request.getName(),
                request.getSurname(),
                request.getPatronymic(),
                request.getPhoneNumber(),
                0,
                0
        ));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<StudentResponse>> getStudents() {
        List<StudentResponse> students = studentService.getStudents().stream().map(student -> new StudentResponse(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getPatronymic(),
                student.getPhoneNumber()
        )).toList();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
