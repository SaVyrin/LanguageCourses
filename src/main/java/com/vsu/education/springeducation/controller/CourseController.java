package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.entity.CourseEntity;
import com.vsu.education.springeducation.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public ResponseEntity<CourseEntity> addCourse(@RequestBody CourseEntity courseEntity) {
        courseService.addCourse(courseEntity);
        return new ResponseEntity<>(courseEntity, HttpStatus.OK);
    }


    @GetMapping("/get")
    public ResponseEntity<List<CourseEntity>> getCourse() {
        List<CourseEntity> cours = courseService.getCourses();
        return new ResponseEntity<>(cours, HttpStatus.OK);
    }
}
