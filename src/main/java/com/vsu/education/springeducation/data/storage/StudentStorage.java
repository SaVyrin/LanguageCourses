package com.vsu.education.springeducation.data.storage;

import com.vsu.education.springeducation.data.entity.CourseEntity;
import com.vsu.education.springeducation.data.entity.StudentEntity;
import com.vsu.education.springeducation.data.domain.Student;
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

    public void addStudent(Student student) {
        jdbcTemplate.update(
                "INSERT INTO students (id, name, surname, patronymic, phone_number, course_id, course_time)" +
                        " VALUES(?,?,?,?,?,?,?)",
                count() + 1, student.getName(), student.getSurname(), student.getPatronymic(), student.getPhoneNumber(), student.getCourseEntity().getId(), student.getCourseTime()
        );
    }

    public void updateStudentCourse(Student student, CourseEntity courseEntity) {
        jdbcTemplate.execute(
                "UPDATE students SET course_id = " + courseEntity.getId()
                        + " WHERE id = " + student.getId()
        );
    }

    public void updateStudentCourseTime(Student student) {
        jdbcTemplate.execute(
                "UPDATE students SET course_time = " + student.getCourseTime()
                        + " WHERE id = " + student.getId()
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
