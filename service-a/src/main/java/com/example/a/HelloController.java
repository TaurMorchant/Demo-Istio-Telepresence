package com.example.b;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping("/api/greet")
    public String greet(@RequestParam(defaultValue = "world") String name) {
        return "Hello, " + name + " from service-b!";
    }
}
