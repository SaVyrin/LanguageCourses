package com.vsu.education.springeducation.service;

import com.vsu.education.springeducation.data.model.StudentEntity;
import com.vsu.education.springeducation.data.model.StudentWithCourseEntity;
import com.vsu.education.springeducation.data.storage.CourseStorage;
import com.vsu.education.springeducation.data.storage.StudentStorage;
import org.springframework.stereotype.Service;
import java.util.List;

// @Controller == @service ~= @Repository == @Component
@Service
public class StudentService {
    private final StudentStorage studentStorage;
    private final CourseStorage courseStorage;

    public StudentService(StudentStorage studentStorage, CourseStorage courseStorage) {
        this.studentStorage = studentStorage;
        this.courseStorage = courseStorage;
    }

    public void addStudent(StudentWithCourseEntity studentWithCourseEntity) {
        studentStorage.addStudent(studentWithCourseEntity);
    }

    public StudentWithCourseEntity getStudentWithCourseById(int studentId, int courseId) {
        var student = studentStorage.getStudentById(studentId);
        var course = courseStorage.getCourseById(courseId);
        return new StudentWithCourseEntity(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getPatronymic(),
                student.getPhoneNumber(),
                course,
                student.getCourseTime()
        );
    }

    public List<StudentEntity> getStudents() {
        return studentStorage.getAllStudents();
    }
}
