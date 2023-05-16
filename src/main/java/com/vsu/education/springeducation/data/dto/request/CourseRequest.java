package com.vsu.education.springeducation.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String language;
    private Integer level;
    private Integer duration;
    private Integer intensity;
    private Integer price;
}
