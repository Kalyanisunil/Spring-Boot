package com.example.cruddemo.rest;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.dao.EmployeeDaoImpl;
import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

   private EmployeeService employeeservice;

    public EmployeeRestController(EmployeeService service)
    {
        employeeservice=service;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeservice.findAll();
    }

    @GetMapping("/employees/{theEmployeeId}")
    public Employee getEmployeeById(@PathVariable int theEmployeeId)
    {
           Employee theEmployee=employeeservice.findById(theEmployeeId);
           if(theEmployee==null)
           {
               throw  new RuntimeException("Employee id not found!");
           }
           return  theEmployee;
    }
//

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeservice.save(theEmployee);

        return dbEmployee;
    }
}
