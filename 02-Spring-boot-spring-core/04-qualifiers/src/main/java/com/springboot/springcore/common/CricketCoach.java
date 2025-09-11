package com.springboot.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkOut() {
        return "Practice bowling for 10 minutes";
    }
}
