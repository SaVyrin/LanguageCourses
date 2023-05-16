package com.vsu.education.springeducation.data.domain;

import com.vsu.education.springeducation.data.entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;
    CourseEntity courseEntity = null;
    int courseTime = 0;

    public boolean finishedCourse() {
        if (courseEntity == null) return false;

        return canGoToNextLevel() && courseEntity.getLevel() == CourseEntity.MAX_COURSE_LEVEL;
    }

    public boolean canGoToNextLevel() {
        if (courseEntity == null) return false;

        return courseEntity.getDuration() <= getCourseTime();
    }

    public void goToNextLevel() {
        courseTime = 0;
        courseEntity = new CourseEntity(
                courseEntity.getId(),
                courseEntity.getLanguage(),
                courseEntity.getLevel(),
                courseEntity.getDuration(),
                courseEntity.getIntensity(),
                courseEntity.getPrice()
        );
    }
}
