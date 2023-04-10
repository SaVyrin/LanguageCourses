package com.vsu.education.springeducation.service;

import com.vsu.education.springeducation.data.model.CourseApplication;
import com.vsu.education.springeducation.data.storage.CourseApplicationStorage;
import org.springframework.stereotype.Service;

import java.util.List;

// @Controller == @service ~= @Repository == @Component
@Service
public class CourseApplicationService {
    private final CourseApplicationStorage courseApplicationStorage;

    public CourseApplicationService(CourseApplicationStorage courseApplicationStorage) {
        this.courseApplicationStorage = courseApplicationStorage;
    }

    public void addCourseApplication(CourseApplication courseApplication) {
        courseApplicationStorage.addCourseApplication(courseApplication);
    }

    public List<CourseApplication> getCourseApplications() {
        return courseApplicationStorage.getAllCourseApplications();
    }
}
