package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.model.CourseApplication;
import com.vsu.education.springeducation.service.CourseApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course/application")
public class CourseApplicationController {
    private final CourseApplicationService courseApplicationService;

    public CourseApplicationController(CourseApplicationService courseApplicationService) {
        this.courseApplicationService = courseApplicationService;
    }

    @PostMapping("/add")
    public ResponseEntity<CourseApplication> addCourse(@RequestBody CourseApplication courseApplication) {
        courseApplicationService.addCourseApplication(courseApplication);
        return new ResponseEntity<>(courseApplication, HttpStatus.OK);
    }


    @GetMapping("/get")
    public ResponseEntity<List<CourseApplication>> getCourseApplications() {
        List<CourseApplication> courseApplications = courseApplicationService.getCourseApplications();
        return new ResponseEntity<>(courseApplications, HttpStatus.OK);
    }
}
