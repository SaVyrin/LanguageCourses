package com.vsu.education.springeducation.data.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentsGroup {
    private final Integer id;
    private final Course course;
    private final List<Student> students;

    public StudentsGroup(int id, Course course, List<Student> students) {
        this.id = id;
        this.course = course;
        this.students = students;
    }
}
