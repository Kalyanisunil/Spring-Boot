package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDao;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDao studentdao)
	{
	   return  runner->{
		   createStudent(studentdao);
	   };
	}

	private void createStudent(StudentDao studentdao) {
		//create student object
		System.out.println("creating new student");
		Student newStudent= new Student("Kalyani","sunil","kallu@gmail.com");

		//save student obj
		System.out.println("saving student");
		studentdao.save(newStudent);

		//display id of saved student
		System.out.println("saved student with id :"+ newStudent.getId());

	}
}
