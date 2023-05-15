package com.vsu.education.springeducation.data.storage;

import com.vsu.education.springeducation.data.model.CourseEntity;
import com.vsu.education.springeducation.data.model.StudentEntity;
import com.vsu.education.springeducation.data.model.StudentWithCourseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentStorage {
    private final JdbcTemplate jdbcTemplate;

    public StudentStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addStudent(StudentWithCourseEntity studentWithCourseEntity) {
        jdbcTemplate.update(
                "INSERT INTO students (id, name, surname, patronymic, phone_number, course_id, course_time)" +
                        " VALUES(?,?,?,?,?,?,?)",
                count() + 1, studentWithCourseEntity.getName(), studentWithCourseEntity.getSurname(), studentWithCourseEntity.getPatronymic(), studentWithCourseEntity.getPhoneNumber(), studentWithCourseEntity.getCourseEntity().getId(), studentWithCourseEntity.getCourseTime()
        );
    }

    public void updateStudentCourse(StudentWithCourseEntity studentWithCourseEntity, CourseEntity courseEntity) {
        jdbcTemplate.execute(
                "UPDATE students SET course_id = " + courseEntity.getId()
                        + " WHERE id = " + studentWithCourseEntity.getId()
        );
    }

    public void updateStudentCourseTime(StudentWithCourseEntity studentWithCourseEntity) {
        jdbcTemplate.execute(
                "UPDATE students SET course_time = " + studentWithCourseEntity.getCourseTime()
                        + " WHERE id = " + studentWithCourseEntity.getId()
        );
    }

    public StudentEntity getStudentById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM students WHERE id=?",
                BeanPropertyRowMapper.newInstance(StudentEntity.class), id);
    }

    public List<StudentEntity> getStudentsByIds(String idsString) {
        return jdbcTemplate.query(String.format("SELECT * FROM students WHERE id IN (%s)", idsString),
                BeanPropertyRowMapper.newInstance(StudentEntity.class));
    }

    public List<StudentEntity> getAllStudents() {
        return jdbcTemplate.query("SELECT * from students",
                BeanPropertyRowMapper.newInstance(StudentEntity.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM students", Integer.class);
    }
}
