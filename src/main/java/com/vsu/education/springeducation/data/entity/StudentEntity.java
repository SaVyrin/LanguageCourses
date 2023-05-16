package com.vsu.education.springeducation.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;
    int courseId;
    int courseTime;
}
