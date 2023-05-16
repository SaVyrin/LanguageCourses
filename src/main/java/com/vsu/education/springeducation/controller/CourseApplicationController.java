package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.domain.CourseApplication;
import com.vsu.education.springeducation.data.dto.request.CourseApplicationRequest;
import com.vsu.education.springeducation.data.dto.response.CourseApplicationResponse;
import com.vsu.education.springeducation.data.dto.response.CourseResponse;
import com.vsu.education.springeducation.data.dto.response.StudentResponse;
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
    public ResponseEntity<Object> addCourse(@RequestBody CourseApplicationRequest request) {
        courseApplicationService.addCourseApplication(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/get")
    public ResponseEntity<List<CourseApplicationResponse>> getCourseApplications() {
        List<CourseApplicationResponse> courseApplicationEntities = courseApplicationService.getCourseApplications().stream().map(application -> {
            var student = new StudentResponse(
                    application.getStudent().getId(),
                    application.getStudent().getName(),
                    application.getStudent().getSurname(),
                    application.getStudent().getPatronymic(),
                    application.getStudent().getPhoneNumber()
            );
            var course = new CourseResponse(
                    application.getCourseEntity().getId(),
                    application.getCourseEntity().getLanguage(),
                    application.getCourseEntity().getLevel(),
                    application.getCourseEntity().getDuration(),
                    application.getCourseEntity().getIntensity(),
                    application.getCourseEntity().getPrice()
            );
            return new CourseApplicationResponse(
                    application.getId(),
                    student,
                    course
            );
        }).toList();
        return new ResponseEntity<>(courseApplicationEntities, HttpStatus.OK);
    }


    @PostMapping("/end")
    public ResponseEntity<Object> endApplications() {
        courseApplicationService.endApplications();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
