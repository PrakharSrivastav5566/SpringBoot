package com.example.Revision;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Revision {
    @GetMapping("/")
    public String Hello(){
        return "Welcome to this project";
    }

    @GetMapping("/sec")
    public String two(){
        return "This is the second route";
    }
    @GetMapping("/th")
    public String third(){
        return "This is the third route";
    }
}