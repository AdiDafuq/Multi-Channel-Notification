package com.jobtracker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class JobtrackerApplication {
    

    public static void main(String[] args) {
        SpringApplication.run(JobtrackerApplication.class, args);
    }
    @Bean
public WebClient.Builder webClientBuilder() {
    return WebClient.builder();
}
}