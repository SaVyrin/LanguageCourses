package com.vsu.education.springeducation.service;

import com.vsu.education.springeducation.data.model.StudentsGroup;
import com.vsu.education.springeducation.data.storage.StudentsGroupStorage;
import org.springframework.stereotype.Service;

// @Controller == @service ~= @Repository == @Component
@Service
public class StudentsGroupService {
    private final StudentsGroupStorage studentsGroupStorage;

    public StudentsGroupService(StudentsGroupStorage studentsGroupStorage) {
        this.studentsGroupStorage = studentsGroupStorage;
    }

    public void addStudentsGroup(StudentsGroup studentsGroup) {
        studentsGroupStorage.addStudentsGroup(studentsGroup);
    }
}
