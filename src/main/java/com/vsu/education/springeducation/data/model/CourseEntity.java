package com.vsu.education.springeducation.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {
    private Integer id;
    private String language;
    private Integer level;
    private Integer duration;
    private Integer intensity;
    private Integer price;

    public static final int MAX_COURSE_LEVEL = 5;
}
