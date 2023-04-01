package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.model.Course;
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

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }


    @GetMapping("/get")
    public ResponseEntity<List<Course>> getCourse() {
        List<Course> courses = courseService.getCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
