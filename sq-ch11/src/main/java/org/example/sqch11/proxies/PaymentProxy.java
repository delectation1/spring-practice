package org.example.sqch11.proxies;

import org.example.sqch11.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments",
             url = "${name.service.url}")
public interface PaymentProxy {
    @PostMapping("/payment")
    Payment createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    );
}