package com.StartingSpring.mycoolapp.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //injecting props for coach name and team name
    @Value("${coach.name}")
    private String coachName;
    @Value("${coach2.name}")
    private String coach2Name;

    @Value("${team.name}")
    private String teamName;

    //exposing new endpoint for team name
    @GetMapping("/teamInfo")
    public String teamInfo()
    {
        return  "Coaches name: " + coachName + " " +coach2Name + "Team name: "+teamName;
    }
    //expose "/" that returns hello world

    @GetMapping("/")
    public String sayHellow()
    {

        return "Hello World!";
    }

    @GetMapping("/workout")
    public String beCool()
    {
        return "Hey you are awesome";
    }

    @GetMapping("/dream")
    public String dreamIt()
    {
        return "If u dream it you do it!";
    }
    @GetMapping("/manifest")
    public String manifest()
    {
        return "If i can u can";
    }



}
