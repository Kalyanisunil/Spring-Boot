package com.springboot.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach()
    {
        System.out.println("in constructor:"
                +getClass().getSimpleName());
    }
    //define out init method
    @PostConstruct
    public  void doStartupWork()
    {
        System.out.println("in doStartupWork():"+ getClass().getSimpleName());

    }

    @PreDestroy
    public  void doCleanupStuff()
    {
        System.out.println("in docleanupstuff():"+ getClass().getSimpleName());

    }
    @Override
    public String getDailyWorkOut() {
        return "Practice bowling for 10 minutes";
    }
}
