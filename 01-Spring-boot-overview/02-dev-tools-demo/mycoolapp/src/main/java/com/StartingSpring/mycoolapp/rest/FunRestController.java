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
