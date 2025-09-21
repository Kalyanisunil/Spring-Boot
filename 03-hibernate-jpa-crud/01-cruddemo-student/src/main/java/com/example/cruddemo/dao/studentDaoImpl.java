package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
