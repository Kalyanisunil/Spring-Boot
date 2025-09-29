package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl (EntityManager theEntityManager)
    {
        entityManager=theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery <Employee> theQuery=entityManager.createQuery("FROM Employee",Employee.class);
        List <Employee> employees=theQuery.getResultList();
        return employees;
    }
}
