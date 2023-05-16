package com.vsu.education.springeducation.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseApplicationRequest {
    private Integer studentId;
    private Integer courseId;
}
