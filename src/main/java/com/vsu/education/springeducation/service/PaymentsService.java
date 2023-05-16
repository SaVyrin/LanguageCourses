package com.vsu.education.springeducation.service;

import com.vsu.education.springeducation.data.entity.PaymentEntity;
import com.vsu.education.springeducation.data.storage.PaymentsStorage;
import org.springframework.stereotype.Service;
import java.util.List;

// @Controller == @service ~= @Repository == @Component
@Service
public class PaymentsService {
    private final PaymentsStorage paymentsStorage;

    public PaymentsService(PaymentsStorage paymentsStorage) {
        this.paymentsStorage = paymentsStorage;
    }

    public void addPayments(PaymentEntity paymentEntity) {
        paymentsStorage.addPayments(paymentEntity);
    }

    public List<PaymentEntity> getPayments() {
        return paymentsStorage.getAllPayments();
    }
}
