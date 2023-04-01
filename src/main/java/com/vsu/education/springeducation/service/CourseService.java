package com.vsu.education.springeducation.service;

import com.vsu.education.springeducation.data.model.Course;
import com.vsu.education.springeducation.data.storage.CourseStorage;
import org.springframework.stereotype.Service;
import java.util.List;

// @Controller == @service ~= @Repository == @Component
@Service
public class CourseService {
    private final CourseStorage courseStorage;

    public CourseService(CourseStorage courseStorage) {
        this.courseStorage = courseStorage;
    }

    public void addCourse(Course course) {
        courseStorage.addCourse(course);
    }

    public List<Course> getCourses() {
        return courseStorage.getAllCourses();
    }
}
