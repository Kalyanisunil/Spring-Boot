package com.example.cruddemo.rest;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.dao.EmployeeDaoImpl;
import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
