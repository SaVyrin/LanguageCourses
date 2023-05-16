package com.vsu.education.springeducation.data.dto.response;

import com.vsu.education.springeducation.data.dto.request.StudentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentsGroupResponse {
    private Integer id;
    private List<StudentResponse> students;
}
