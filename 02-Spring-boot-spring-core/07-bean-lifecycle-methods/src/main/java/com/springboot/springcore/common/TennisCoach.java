package com.springboot.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    public TennisCoach()
    {
        System.out.println("in constructor:"
                +getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Spend 5 minutes swinging";
    }
}
