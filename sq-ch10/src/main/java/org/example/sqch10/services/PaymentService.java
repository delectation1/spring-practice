package org.example.sqch10.services;

import org.example.sqch10.exceptions.NotEnoughMoneyException;
import org.example.sqch10.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}