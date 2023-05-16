package com.vsu.education.springeducation.data.domain;

import com.vsu.education.springeducation.data.entity.CourseEntity;
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
    private Student student;
    private CourseEntity courseEntity;
}
