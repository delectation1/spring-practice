package org.example.sqch11.controllers;

import org.example.sqch11.model.Payment;
import org.example.sqch11.proxies.PaymentProxy;
import org.example.sqch11.proxies.PaymentProxy2;
import org.example.sqch11.proxies.PaymentProxy3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {
    private static Logger logger = Logger.getLogger(PaymentController.class.getName());
    private final PaymentProxy paymentProxy;
    private final PaymentProxy2 paymentProxy2;
    private final PaymentProxy3 paymentProxy3;

    @Autowired
    public PaymentController(PaymentProxy paymentProxy, PaymentProxy2 paymentProxy2, PaymentProxy3 paymentProxy3) {
        this.paymentProxy = paymentProxy;
        this.paymentProxy2 = paymentProxy2;
        this.paymentProxy3 = paymentProxy3;
    }

    @PostMapping("/payment")
    public Mono<Payment> createPayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        return paymentProxy3.createPayment(requestId, payment);
    }

//    @PostMapping("/payment")
//    public Payment createPayment(
//            @RequestBody Payment payment
//    ) {
//        return paymentProxy2.createPayment(payment);
//    }

//    @PostMapping("/payment")
//    public Payment createPayment(
//            @RequestBody Payment payment
//    ) {
//        String requestId = UUID.randomUUID().toString();
//        logger.info("Received request with ID " + requestId +
//                " and payment amount: " + payment.getAmount());
//        payment = paymentProxy.createPayment(requestId, payment);
//        return payment;
//    }

    //    @PostMapping("/payment")
//    public ResponseEntity<Payment> payment(
//            @RequestHeader String requestId,
//            @RequestBody Payment payment) {
//        logger.info("Received request with ID " + requestId +
//                " and payment amount: " + payment.getAmount());
//
//        payment.setId(UUID.randomUUID().toString());
//
//        return ResponseEntity.status(HttpStatus.OK)
//                             .header("requestId", requestId)
//                             .body(payment);
//    }
}