package com.vsu.education.springeducation.service;

import com.vsu.education.springeducation.data.model.Student;
import com.vsu.education.springeducation.data.storage.StudentStorage;
import org.springframework.stereotype.Service;

// @Controller == @service ~= @Repository == @Component
@Service
public class StudentService {
    private final StudentStorage studentStorage;

    public StudentService(StudentStorage studentStorage) {
        this.studentStorage = studentStorage;
    }

    public void addStudent(Student student){
        studentStorage.addStudent(student);
    }
}
