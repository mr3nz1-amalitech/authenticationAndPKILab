package com.example.authenticationAndPKILab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/example")
public class ExampleController {
    @GetMapping({"", "/"})
    public String index() {
        System.out.println("Hello World");
        return "Hello World";
    }
}
