package com.vsu.education.springeducation.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;
}
