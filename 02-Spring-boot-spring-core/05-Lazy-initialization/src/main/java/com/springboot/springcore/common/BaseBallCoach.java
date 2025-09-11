package com.springboot.springcore.common;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements  Coach{
    public BaseBallCoach()
    {
        System.out.println("in constructor:"
        +getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Spend 19 minutes batting";
    }
}
