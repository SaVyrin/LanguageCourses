package com.vsu.education.springeducation.data.storage;

import com.vsu.education.springeducation.data.model.Course;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class CourseStorage {
    private HashMap<Integer, Course> coyrsesHashMap = new HashMap<>();

    public void addCourse(Course course) {
        coyrsesHashMap.put(course.getId(), course);
    }

    public List<Course> getAllCourses() {
        return coyrsesHashMap.values().stream().toList();
    }
}
