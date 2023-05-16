package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.entity.PaymentEntity;
import com.vsu.education.springeducation.service.PaymentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentsController {
    private final PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @PostMapping("/add")
    public ResponseEntity<PaymentEntity> addPayments(@RequestBody PaymentEntity paymentEntity) {
        paymentsService.addPayments(paymentEntity);
        return new ResponseEntity<>(paymentEntity, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<PaymentEntity>> getPayments() {
        List<PaymentEntity> payments = paymentsService.getPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }
}
