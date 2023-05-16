package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.domain.Student;
import com.vsu.education.springeducation.data.domain.StudentsGroup;
import com.vsu.education.springeducation.data.dto.request.StudentsGroupRequest;
import com.vsu.education.springeducation.data.dto.response.StudentResponse;
import com.vsu.education.springeducation.data.dto.response.StudentsGroupResponse;
import com.vsu.education.springeducation.data.entity.StudentsGroupEntity;
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
    public ResponseEntity<Object> addStudentsGroup(@RequestBody StudentsGroupRequest request) {
        var students = String.join(",", request.getStudentsIds());
        studentsGroupService.addStudentsGroup(new StudentsGroupEntity(0, students));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<StudentsGroupResponse>> getStudentsGroup() {
        List<StudentsGroupResponse> studentsGroupEntity = studentsGroupService.getStudentsGroups().stream().map(group -> {
            var students = group.getStudentEntities().stream().map(student -> new StudentResponse(
                    student.getId(),
                    student.getName(),
                    student.getSurname(),
                    student.getPatronymic(),
                    student.getPhoneNumber()
            )).toList();

            return new StudentsGroupResponse(
                    group.getId(),
                    students
            );
        }).toList();
        return new ResponseEntity<>(studentsGroupEntity, HttpStatus.OK);
    }
}
