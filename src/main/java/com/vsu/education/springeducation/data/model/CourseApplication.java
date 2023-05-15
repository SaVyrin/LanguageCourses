package com.vsu.education.springeducation.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseApplication {
    private Integer id;
    private StudentWithCourseEntity studentWithCourseEntity;
    private CourseEntity courseEntity;
}
