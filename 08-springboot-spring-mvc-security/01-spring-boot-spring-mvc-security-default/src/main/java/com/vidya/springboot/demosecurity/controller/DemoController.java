package com.vidya.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public  String showHome(){
        return "home";
    }

//    add a request mappng to leaders
@GetMapping("/leaders")
public  String showLeaders(){
    return "leaders";
}
}
