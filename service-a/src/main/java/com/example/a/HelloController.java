package com.example.a;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@RestController
public class HelloController {

    private final RestClient rest;
    private final String downstream;

    public HelloController(RestClient rest,
                           @Value("${downstream.baseUrl:http://service-b:8080}") String downstream) {
        this.rest = rest;
        this.downstream = downstream;
    }

    @GetMapping("/api/hello")
    public String hello(@RequestParam(defaultValue = "world") String name) {
        String msg = rest.get()
                .uri(downstream + "/api/greet?name={name}", name)
                .retrieve()
                .body(String.class);
        return "service-a → " + msg;
    }
}
