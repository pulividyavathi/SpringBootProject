package com.vidya.learn.springboot.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class FunController {
    //expose / return hello world
@GetMapping("/")
    public String sayHello(){
            return "Hello World";
    }

    // expose a new endpoint for workout

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "success done!";
    }
    //expose a new endpoint for fortune
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is Your lucky day!";
    }

}
