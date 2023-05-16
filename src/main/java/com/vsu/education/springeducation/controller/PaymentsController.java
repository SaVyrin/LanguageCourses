package com.vsu.education.springeducation.controller;

import com.vsu.education.springeducation.data.dto.request.PaymentRequest;
import com.vsu.education.springeducation.data.dto.response.PaymentResponse;
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
    public ResponseEntity<Object> addPayments(@RequestBody PaymentRequest request) {
        paymentsService.addPayments(new PaymentEntity(0, request.getStudent_id(), request.getCourse_id(), request.getValue()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<PaymentResponse>> getPayments() {
        List<PaymentResponse> payments = paymentsService.getPayments().stream().map(payment -> new PaymentResponse(
                payment.getId(),
                payment.getStudent_id(),
                payment.getCourse_id(),
                payment.getValue()
        )).toList();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }
}
