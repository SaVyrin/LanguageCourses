package com.vsu.education.springeducation.data.storage;

import com.vsu.education.springeducation.data.model.Student;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class StudentStorage {
    private HashMap<Integer, Student> studentHashMap = new HashMap<>();

    public void addStudent(Student student) {
        studentHashMap.put(student.getId(), student);
    }

    public List<Student> getAllStudent() {
        return studentHashMap.values().stream().toList();
    }
}
