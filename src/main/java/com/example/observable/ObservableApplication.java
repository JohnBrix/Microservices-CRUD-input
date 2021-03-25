package com.example.observable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ObservableApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObservableApplication.class, args);
    }

}
