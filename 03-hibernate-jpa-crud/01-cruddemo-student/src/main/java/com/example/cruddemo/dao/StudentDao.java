package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    void save (Student student);

    Student findById(Integer id);

    public List<Student> findAll();

    List<Student> findByLastName(String thelastName);

   void  updateLastName(Student theStudent);
   void deleteStudent(Integer id);



}
