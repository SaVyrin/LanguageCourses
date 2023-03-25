package com.vsu.education.springeducation.data.storage;

import com.vsu.education.springeducation.data.model.Payments;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class PaymentsStorage {
    private HashMap<Integer, Payments> paymentsHashMap = new HashMap<>();

    public void addPayments(Payments payments) {
        paymentsHashMap.put(payments.getId(), payments);
    }

    public List<Payments> getAllPayments() {
        return paymentsHashMap.values().stream().toList();
    }
}
