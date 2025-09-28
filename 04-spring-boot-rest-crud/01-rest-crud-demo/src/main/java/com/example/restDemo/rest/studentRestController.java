package com.example.restDemo.rest;

import com.example.restDemo.entity.student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    if(studentId>= theStudents.size()|| studentId<0)
    {
        throw new StudentNotFoundException("Student with id not found:-"+studentId);
    }
    return theStudents.get(studentId);
}
// adding an exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception)
    {
        StudentErrorResponse error= new StudentErrorResponse() ;
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return  new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e)
    {
        StudentErrorResponse error= new StudentErrorResponse() ;
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
