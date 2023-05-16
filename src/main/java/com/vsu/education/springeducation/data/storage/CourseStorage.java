package com.vsu.education.springeducation.data.storage;

import com.vsu.education.springeducation.data.dto.request.CourseRequest;
import com.vsu.education.springeducation.data.entity.CourseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseStorage {
    private final JdbcTemplate jdbcTemplate;

    public CourseStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCourse(CourseRequest courseEntity) {
        jdbcTemplate.update(
                "INSERT INTO course (id, language, level, duration, intensity, price)" +
                        " VALUES(?,?,?,?,?,?)",
                count() + 1, courseEntity.getLanguage(), courseEntity.getLevel(), courseEntity.getDuration(), courseEntity.getIntensity(), courseEntity.getPrice()
        );
    }

    public CourseEntity getCourseById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM course WHERE id=?",
                BeanPropertyRowMapper.newInstance(CourseEntity.class), id);
    }

    public List<CourseEntity> getAllCourses() {
        return jdbcTemplate.query("SELECT * from course",
                BeanPropertyRowMapper.newInstance(CourseEntity.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM course", Integer.class);
    }
}
