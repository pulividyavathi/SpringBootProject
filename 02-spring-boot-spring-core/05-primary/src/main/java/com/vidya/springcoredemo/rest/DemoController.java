package com.vidya.springcoredemo.rest;

import com.vidya.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
//    define a private field for the dependency
    private Coach mycoach;

////    define a constructor for dependency injection
@Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
         mycoach=theCoach;
    }

//    @Autowired
//    //Setter injection
//    public void setCoach(Coach theCoach){
//        mycoach=theCoach;
//    }
@GetMapping("/dailyworkout")
    public String getDailyWorkout(){
      return mycoach.getDailyWorkout();
}


}
