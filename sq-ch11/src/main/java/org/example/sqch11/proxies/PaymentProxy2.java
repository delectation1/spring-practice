package org.example.sqch11.proxies;

import org.example.sqch11.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class PaymentProxy2 {
    private final RestTemplate rest;

    @Value("${name.service.url}")
    private String paymentServiceUrl;

    @Autowired
    public PaymentProxy2(RestTemplate rest) {
        this.rest = rest;
    }

    public Payment createPayment(Payment payment) {
        String url = paymentServiceUrl + "/payment";

        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment,headers);

        ResponseEntity<Payment> response = rest.exchange(url, HttpMethod.POST, httpEntity, Payment.class);

        return response.getBody();
    }
}
