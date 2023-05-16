package com.vsu.education.springeducation.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {
    private Integer id;
    private int student_id;
    private int course_id;
    private int value;
}
