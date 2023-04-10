package com.vsu.education.springeducation.data.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseApplication {
    private final Integer id;
    private final Student student;
    private final Course course;

    public CourseApplication(
            int id,
            Student student,
            Course course
    ) {
        this.id = id;
        this.student = student;
        this.course = course;
    }
}
