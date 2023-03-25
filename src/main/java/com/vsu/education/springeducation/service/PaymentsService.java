package com.vsu.education.springeducation.service;

import com.vsu.education.springeducation.data.model.Payments;
import com.vsu.education.springeducation.data.storage.PaymentsStorage;
import org.springframework.stereotype.Service;

// @Controller == @service ~= @Repository == @Component
@Service
public class PaymentsService {
    private final PaymentsStorage paymentsStorage;

    public PaymentsService(PaymentsStorage paymentsStorage) {
        this.paymentsStorage = paymentsStorage;
    }

    public void addPayments(Payments payments){
        paymentsStorage.addPayments(payments);
    }
}
