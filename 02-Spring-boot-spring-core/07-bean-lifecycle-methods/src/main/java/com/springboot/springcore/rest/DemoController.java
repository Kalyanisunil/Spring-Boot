package com.springboot.springcore.rest;

import com.springboot.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define private fields for dependency
    private Coach myCoach;


    @Autowired
    //bean name should have the first letter lowercased
    //CricketCoach-> bean name =cricketCoach
    public DemoController(@Qualifier("cricketCoach") Coach theCoach
                         ) {
        System.out.println("in constructor:"
                +getClass().getSimpleName());
        myCoach = theCoach;

    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout()
    {
        return myCoach.getDailyWorkOut();
    }


}


