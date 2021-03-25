package com.example.observable.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class PersonImplService {
    @Bean
    public String uri() {
        return "http://localhost:8081/api/person";
    }
    @Bean
    public String uriDelete(){
        return "http://localhost:8081/api/person?id=";
    }
}
