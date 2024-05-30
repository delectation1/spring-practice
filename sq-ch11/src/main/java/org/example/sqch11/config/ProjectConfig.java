package org.example.sqch11.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableFeignClients(
        basePackages = "org.example.sqch11.proxies")
public class ProjectConfig {
    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                        .build();
    }
}