package org.example.sqch10.controllers;

import org.example.sqch10.model.PaymentDetails;
import org.example.sqch10.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {
    private static Logger logger =
            Logger.getLogger(PaymentController.class.getName());
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

//    @PostMapping("/payment")
//    public ResponseEntity<?> makePayment() {
////        try {
//            PaymentDetails paymentDetails = paymentService.processPayment();
//
//            return ResponseEntity.status(HttpStatus.ACCEPTED)
//                                 .body(paymentDetails);
////        } catch (NotEnoughMoneyException e) {
////            ErrorDetails errorDetails = new ErrorDetails();
////            errorDetails.setMessage("Not enough money to make the payment.");
////
////            return ResponseEntity.badRequest().body(errorDetails);
////        }
//    }
    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(
            @RequestBody PaymentDetails paymentDetails) {
        logger.info("Received payment " + paymentDetails.getAmount());

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                             .body(paymentDetails);
    }
}