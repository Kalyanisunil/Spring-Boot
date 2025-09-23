package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class studentDaoImpl  implements  StudentDao{


    //define field for entity manager
    private EntityManager entityManager;

    @Autowired
    public studentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //inject  entity manager using constructor



    //implement save method
    @Override
    @Transactional
    public void save(Student student) {
    entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class ,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String thelastName) {
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student where lastName=:theData", Student.class);
        theQuery.setParameter("theData",thelastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateLastName(Student theStudent) {
    entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        Student theStudent=entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }


}
