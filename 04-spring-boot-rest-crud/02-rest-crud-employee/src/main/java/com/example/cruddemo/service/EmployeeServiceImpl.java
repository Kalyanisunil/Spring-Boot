package com.example.cruddemo.service;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
     private EmployeeDAO empDAO;

     @Autowired
     public  EmployeeServiceImpl(EmployeeDAO empdao)
     {
         empDAO=empdao;
     }
    @Override
    public List<Employee> findAll() {
            return empDAO.findAll();
    }
}
