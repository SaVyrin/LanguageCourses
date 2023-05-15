package com.vsu.education.springeducation.data.storage;

import com.vsu.education.springeducation.data.model.PaymentsEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentsStorage {

        private final JdbcTemplate jdbcTemplate;

    public PaymentsStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addPayments(PaymentsEntity paymentsEntity) {
        jdbcTemplate.update(
                "INSERT INTO payments (id, student_id, course_id, value)" +
                        " VALUES(?,?,?,?)",
                count() + 1, paymentsEntity.getStudent_id(), paymentsEntity.getCourse_id(), paymentsEntity.getValue()
        );
    }

    public List<PaymentsEntity> getAllPayments() {
        return jdbcTemplate.query("SELECT * from payments",
                BeanPropertyRowMapper.newInstance(PaymentsEntity.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM payments", Integer.class);
    }
}
