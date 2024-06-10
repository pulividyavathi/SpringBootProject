package com.vidya.springcoredemo.rest;

import com.vidya.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
//    define a private field for the dependency
    private Coach mycoach;
@Autowired
//    define a constructor for dependency injection
    public DemoController(Coach theCoach){
         mycoach=theCoach;
    }
@GetMapping("/dailyworkout")
    public String getDailyWorkout(){
      return mycoach.getDailyWorkout();
}


}
