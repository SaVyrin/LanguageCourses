package com.vsu.education.springeducation.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseApplicationEntity {
    private Integer id;
    private int student_id;
    private int course_id;
}
