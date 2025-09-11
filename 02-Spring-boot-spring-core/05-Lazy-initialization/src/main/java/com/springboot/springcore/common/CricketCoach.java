package com.springboot.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach()
    {
        System.out.println("in constructor:"
                +getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Practice bowling for 10 minutes";
    }
}
