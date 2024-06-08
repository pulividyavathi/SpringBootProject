package com.vidya.learn.springboot.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class FunController {
//    Inject properties
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

//expose an endpoiint to use props
    @GetMapping("/teamInfo")
  public String teamInfo(){
        return "Coach: "+coachName+", Team Name: "+teamName;
    }
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
