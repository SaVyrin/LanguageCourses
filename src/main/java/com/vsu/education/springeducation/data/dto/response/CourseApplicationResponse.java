package com.vsu.education.springeducation.data.dto.response;

import com.vsu.education.springeducation.data.domain.Student;
import com.vsu.education.springeducation.data.entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseApplicationResponse {

    private Integer id;
    private StudentResponse student;
    private CourseResponse course;
}
