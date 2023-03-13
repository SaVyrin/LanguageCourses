package com.vsu.education.springeducation.data.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    private final Integer id;
    private final String language;
    private final Integer level;
    private final Integer duration;
    private final Integer intensity;
    private final Integer price;

    public Course(
            int id,
            String language,
            Integer level,
            Integer duration,
            Integer intensity,
            Integer price
    ) {
        this.id = id;
        this.language = language;
        this.level = level;
        this.duration = duration;
        this.intensity = intensity;
        this.price = price;
    }
}
