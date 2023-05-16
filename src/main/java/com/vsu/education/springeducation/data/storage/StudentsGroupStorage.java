package com.vsu.education.springeducation.data.storage;

import com.vsu.education.springeducation.data.entity.StudentsGroupEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentsGroupStorage {
    private final JdbcTemplate jdbcTemplate;

    public StudentsGroupStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addStudentsGroup(StudentsGroupEntity studentsGroupEntity) {
        jdbcTemplate.update(
                "INSERT INTO students_group (id, students_ids)" +
                        " VALUES(?,?)",
                count() + 1, studentsGroupEntity.getStudents_ids()
        );
    }

    public List<StudentsGroupEntity> getAllStudentsGroups() {
        return jdbcTemplate.query("SELECT * from students_group",
                BeanPropertyRowMapper.newInstance(StudentsGroupEntity.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM students_group", Integer.class);
    }
}
