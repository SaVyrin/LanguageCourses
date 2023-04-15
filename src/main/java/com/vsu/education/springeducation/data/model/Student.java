package com.vsu.education.springeducation.data.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private final Integer id;
    private final String name;
    private final String surname;
    private final String patronymic;
    private final String phoneNumber;
    Course course = null;
    int courseTime = 0;

    public Student(
            int id,
            String name,
            String surname,
            String patronymic,
            String phoneNumber
    ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
    }
}
