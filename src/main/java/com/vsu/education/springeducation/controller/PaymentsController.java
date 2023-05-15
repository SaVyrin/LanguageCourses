package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.model.PaymentsEntity;
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
    public ResponseEntity<PaymentsEntity> addPayments(@RequestBody PaymentsEntity paymentsEntity) {
        paymentsService.addPayments(paymentsEntity);
        return new ResponseEntity<>(paymentsEntity, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<PaymentsEntity>> getPayments() {
        List<PaymentsEntity> payments = paymentsService.getPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }
}
