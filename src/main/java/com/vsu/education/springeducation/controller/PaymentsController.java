package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.model.Payments;
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
    public ResponseEntity<Payments> addPayments(@RequestBody Payments payments) {
        paymentsService.addPayments(payments);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Payments>> getPayments() {
        List<Payments> payments = paymentsService.getPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }
}
