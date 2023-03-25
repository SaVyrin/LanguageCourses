package com.vsu.education.springeducation.data.storage;

import com.vsu.education.springeducation.data.model.StudentsGroup;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class StudentsGroupStorage {
    private HashMap<Integer, StudentsGroup> studentsGroupHashMap = new HashMap<>();

    public void addStudentsGroup(StudentsGroup studentsGroup) {
        studentsGroupHashMap.put(studentsGroup.getId(), studentsGroup);
    }

    public List<StudentsGroup> getAllStudentsGroup() {
        return studentsGroupHashMap.values().stream().toList();
    }
}
