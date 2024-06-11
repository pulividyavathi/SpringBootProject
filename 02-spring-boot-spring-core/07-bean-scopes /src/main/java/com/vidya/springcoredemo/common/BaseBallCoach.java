package com.vidya.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
   public BaseBallCoach(){
       System.out.println("In Constructor"+ getClass().getSimpleName());
   }
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice baseball";
    }
}
