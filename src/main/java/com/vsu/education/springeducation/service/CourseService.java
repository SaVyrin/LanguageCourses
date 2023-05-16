package com.vsu.education.springeducation.service;

import com.vsu.education.springeducation.data.entity.CourseEntity;
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

    public void addCourse(CourseEntity courseEntity) {
        courseStorage.addCourse(courseEntity);
    }

    public List<CourseEntity> getCourses() {
        return courseStorage.getAllCourses();
    }
}
