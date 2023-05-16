package com.vsu.education.springeducation.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;
}
