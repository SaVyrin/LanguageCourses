package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.model.Payments;
import com.vsu.education.springeducation.service.PaymentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentsController {
    private final PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @PostMapping
    public ResponseEntity<Payments> addPayments(@RequestBody Payments payments) {
        paymentsService.addPayments(payments);
        return new ResponseEntity<>(payments, HttpStatus.OK);

    }
}
