package com.example.day1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
 public class day1SB{
    @GetMapping("/")
    public String hello() {
        return "First line of SpringBoot code" ;
    }
    @GetMapping("/Prakhar")
    public String Prakhar(){
        return "this is my first spring project" ;
    }
    @GetMapping("/bye")
    public String bye(){
        return "end of today's class";
    }
    @GetMapping("/routes")
    public String routes(){
        String s="today i learned how to make routes in java LB";

        return s;
    }

}
