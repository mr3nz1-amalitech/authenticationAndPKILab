package com.example.authenticationAndPKILab.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "home";
    }

    @GetMapping("/admin/dashboard")
    public String admin() {
        return "admin";
    }

    @GetMapping("/patient/dashboard")
    public String patient() {
        return "patient";
    }

    @GetMapping("/doctor/dashboard")
    public String doctor() {
        return "doctor";
    }
}
