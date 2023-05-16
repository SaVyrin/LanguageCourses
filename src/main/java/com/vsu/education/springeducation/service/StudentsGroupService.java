package com.vsu.education.springeducation.service;

import com.vsu.education.springeducation.data.entity.CourseEntity;
import com.vsu.education.springeducation.data.domain.Student;
import com.vsu.education.springeducation.data.domain.StudentsGroup;
import com.vsu.education.springeducation.data.entity.StudentsGroupEntity;
import com.vsu.education.springeducation.data.storage.CourseStorage;
import com.vsu.education.springeducation.data.storage.StudentStorage;
import com.vsu.education.springeducation.data.storage.StudentsGroupStorage;
import org.springframework.stereotype.Service;

import java.util.List;

// @Controller == @service ~= @Repository == @Component
@Service
public class StudentsGroupService {
    private final StudentsGroupStorage studentsGroupStorage;
    private final StudentStorage studentStorage;
    private final CourseStorage courseStorage;

    public StudentsGroupService(StudentsGroupStorage studentsGroupStorage, StudentStorage studentStorage, CourseStorage courseStorage) {
        this.studentsGroupStorage = studentsGroupStorage;
        this.studentStorage = studentStorage;
        this.courseStorage = courseStorage;
    }

    public void addStudentsGroup(StudentsGroupEntity studentsGroupEntity) {
        studentsGroupStorage.addStudentsGroup(studentsGroupEntity);
    }

    public List<StudentsGroup> getStudentsGroups() {
        var studentsGroups = studentsGroupStorage.getAllStudentsGroups();
        return studentsGroups.stream().map(group -> {
                    var studentsIds = group.getStudents_ids();
                    var students = studentStorage.getStudentsByIds(studentsIds).stream().map(student -> {
                                CourseEntity course = null;
                                if (student.getCourseId() != 0) {
                                    course = courseStorage.getCourseById(student.getCourseId());
                                }
                                return new Student(
                                        student.getId(),
                                        student.getName(),
                                        student.getSurname(),
                                        student.getPatronymic(),
                                        student.getPhoneNumber(),
                                        course,
                                        student.getCourseTime()
                                );
                            }
                    ).toList();
                    return new StudentsGroup(group.getId(), students);
                }
        ).toList();
    }
}
