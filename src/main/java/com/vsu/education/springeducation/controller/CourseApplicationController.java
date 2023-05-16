package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.domain.CourseApplication;
import com.vsu.education.springeducation.data.entity.CourseApplicationEntity;
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
    public ResponseEntity<CourseApplicationEntity> addCourse(@RequestBody CourseApplication courseApplicationEntity) {
        courseApplicationService.addCourseApplication(courseApplicationEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/get")
    public ResponseEntity<List<CourseApplication>> getCourseApplications() {
        List<CourseApplication> courseApplicationEntities = courseApplicationService.getCourseApplications();
        return new ResponseEntity<>(courseApplicationEntities, HttpStatus.OK);
    }


    @PostMapping("/end")
    public ResponseEntity<Object> endApplications() {
        courseApplicationService.endApplications();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
