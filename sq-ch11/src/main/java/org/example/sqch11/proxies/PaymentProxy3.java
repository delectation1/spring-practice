package org.example.sqch11.proxies;

import org.example.sqch11.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentProxy3 {
    private final WebClient webClient;

    @Value("${name.service.url}")
    private String url;

    @Autowired
    public PaymentProxy3(WebClient webClient) {
        this.webClient = webClient;
    }

    // Mono defines a producer -> return type of Mono also allows subscription
    public Mono<Payment> createPayment(String requestId, Payment payment) {
        return webClient.post()
                        .uri(url + "/payment")
                        .header("requestId", requestId)
                        .body(Mono.just(payment), Payment.class)
                        .retrieve()
                        .bodyToMono(Payment.class);
    }
}
