package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//<Employee,Integer> we put integer because our db has inteegr primary key
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
