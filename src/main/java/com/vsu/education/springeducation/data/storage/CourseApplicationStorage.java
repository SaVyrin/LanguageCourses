package com.vsu.education.springeducation.data.storage;

import com.vsu.education.springeducation.data.model.CourseApplication;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class CourseApplicationStorage {
    private HashMap<Integer, CourseApplication> courseApplicationsHashMap = new HashMap<>();

    public void addCourseApplication(CourseApplication courseApplication) {
        courseApplicationsHashMap.put(courseApplication.getId(), courseApplication);
    }

    public List<CourseApplication> getAllCourseApplications() {
        return courseApplicationsHashMap.values().stream().toList();
    }
}
