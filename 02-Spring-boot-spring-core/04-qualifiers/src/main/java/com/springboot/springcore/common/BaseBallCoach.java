package com.springboot.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements  Coach{
    @Override
    public String getDailyWorkOut() {
        return "Spend 19 minutes batting";
    }
}
