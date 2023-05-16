package com.vsu.education.springeducation.data.storage;

import com.vsu.education.springeducation.data.entity.PaymentEntity;
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

    public void addPayments(PaymentEntity paymentEntity) {
        jdbcTemplate.update(
                "INSERT INTO payments (id, student_id, course_id, value)" +
                        " VALUES(?,?,?,?)",
                count() + 1, paymentEntity.getStudent_id(), paymentEntity.getCourse_id(), paymentEntity.getValue()
        );
    }

    public List<PaymentEntity> getAllPayments() {
        return jdbcTemplate.query("SELECT * from payments",
                BeanPropertyRowMapper.newInstance(PaymentEntity.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM payments", Integer.class);
    }
}
