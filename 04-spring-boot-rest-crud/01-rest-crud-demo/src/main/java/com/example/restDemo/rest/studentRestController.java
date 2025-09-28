package com.example.restDemo.rest;

import com.example.restDemo.entity.student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class studentRestController {


  private   List <student> theStudents;
  @PostConstruct
  public  void loadData()
  {
        theStudents=new ArrayList<>();

      theStudents.add(new student("Kallu","sk"));
      theStudents.add(new student("Kichu","sk"));
      theStudents.add(new student("Kavi","sk"));

  }
@GetMapping("/students")
    public List<student> getSStudents()
{

    return theStudents;
}

@GetMapping("/students/{studentId}")
    public student getStudent( @PathVariable int studentId)
{
    return theStudents.get(studentId);
}

}
