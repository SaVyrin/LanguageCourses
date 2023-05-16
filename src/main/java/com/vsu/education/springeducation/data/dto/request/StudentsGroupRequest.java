package com.vsu.education.springeducation.data.dto.request;

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
public class StudentsGroupRequest {
    private List<String> studentsIds;
}
