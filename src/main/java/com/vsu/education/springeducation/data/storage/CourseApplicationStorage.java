package com.vsu.education.springeducation.data.storage;

import com.vsu.education.springeducation.data.model.CourseApplication;
import com.vsu.education.springeducation.data.model.CourseApplicationEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseApplicationStorage {
    private final JdbcTemplate jdbcTemplate;

    public CourseApplicationStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCourseApplication(CourseApplication courseApplicationEntity) {
        jdbcTemplate.update(
                "INSERT INTO course_application (id, student_id, course_id)" +
                        " VALUES(?,?,?)",
                count() + 1, courseApplicationEntity.getStudentWithCourseEntity().getId(), courseApplicationEntity.getCourseEntity().getId()
        );
    }

    public List<CourseApplicationEntity> getAllCourseApplications() {
        return jdbcTemplate.query("SELECT * from course_application",
                BeanPropertyRowMapper.newInstance(CourseApplicationEntity.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM course_application", Integer.class);
    }
}
