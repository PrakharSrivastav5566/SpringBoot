package com.example.day2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
    @GetMapping("/")
    public String ab(){
        return "index";
    }
    @GetMapping("/about")
    public String ac(){
        return "about";
    }
    @GetMapping("/contact")
    public String ad(){
        return "contact";
    }
}
