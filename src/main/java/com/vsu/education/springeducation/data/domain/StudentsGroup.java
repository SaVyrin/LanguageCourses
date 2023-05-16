package com.vsu.education.springeducation.data.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentsGroup {
    private Integer id;
    private List<Student> studentEntities;

    public String getStudentsIds() {
        List<String> studentsIds = studentEntities.stream().map(student -> student.getId().toString()).toList();
        return String.join(",", studentsIds);
    }
}
