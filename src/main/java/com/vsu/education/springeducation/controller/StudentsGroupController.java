package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.model.StudentsGroup;
import com.vsu.education.springeducation.data.model.StudentsGroupEntity;
import com.vsu.education.springeducation.service.StudentsGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students_group")
public class StudentsGroupController {
    private final StudentsGroupService studentsGroupService;

    public StudentsGroupController(StudentsGroupService studentsGroupService) {
        this.studentsGroupService = studentsGroupService;
    }

    @PostMapping("/add")
    public ResponseEntity<StudentsGroupEntity> addStudentsGroup(@RequestBody StudentsGroupEntity studentsGroupEntity) {
        studentsGroupService.addStudentsGroup(studentsGroupEntity);
        return new ResponseEntity<>(studentsGroupEntity, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<StudentsGroup>> getStudentsGroup() {
        List<StudentsGroup> studentsGroupEntity = studentsGroupService.getStudentsGroups();
        return new ResponseEntity<>(studentsGroupEntity, HttpStatus.OK);
    }
}
