package com.example.restDemo.rest;

import com.example.restDemo.entity.student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class studentRestController {
@GetMapping("/students")
    public List<student> getSStudents()
{
    List <student> theStudents=new ArrayList<>();
    theStudents.add(new student("Kallu","sk"));
    theStudents.add(new student("Kichu","sk"));
    theStudents.add(new student("Kavi","sk"));
    return theStudents;
}

}
