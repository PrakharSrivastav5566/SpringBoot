package com.example.day2part2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping("about/")
    public String about() {
        return "New Hello";
    }
}
