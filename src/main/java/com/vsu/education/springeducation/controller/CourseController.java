package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.dto.request.CourseRequest;
import com.vsu.education.springeducation.data.dto.response.CourseResponse;
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
    public ResponseEntity<Object> addCourse(@RequestBody CourseRequest request) {
        courseService.addCourse(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/get")
    public ResponseEntity<List<CourseResponse>> getCourse() {
        List<CourseResponse> courses = courseService.getCourses().stream().map(course -> new CourseResponse(
                course.getId(),
                course.getLanguage(),
                course.getLevel(),
                course.getDuration(),
                course.getIntensity(),
                course.getPrice()
        )).toList();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
