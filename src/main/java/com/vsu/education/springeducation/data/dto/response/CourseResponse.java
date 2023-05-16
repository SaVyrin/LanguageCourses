package com.vsu.education.springeducation.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {

    private Integer id;
    private String language;
    private Integer level;
    private Integer duration;
    private Integer intensity;
    private Integer price;
}
