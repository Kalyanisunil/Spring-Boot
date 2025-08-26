package com.StartingSpring.mycoolapp.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //expose "/" that returns hello world

    @GetMapping("/")
    public String sayHellow()
    {
        return "Hello World!";
    }
}
