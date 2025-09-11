package com.springboot.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkOut() {
        return "Spend 5 minutes swinging";
    }
}
