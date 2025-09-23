package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDao;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDao studentdao)
	{
	   return  runner->{
//		   createStudent(studentdao);
//		   readStudent(studentdao);
		   queryForStudents(studentdao);
//		   queryForStudentsByLastName(studentdao);
//		   updateStudent(studentdao);
//		  deleteStudentByid(studentdao);
	   };

	}

	private void deleteStudentByid(StudentDao studentdao) {
		int studentId=3;

		System.out.println("deleting...:"+studentId);
		studentdao.deleteStudent(studentId);
	}

	private void updateStudent(StudentDao studentdao) {
		int studentId=1;
		System.out.println("getting student with id:"+studentId);
		Student myStudent=studentdao.findById(studentId);
		System.out.println("updating student...");
		myStudent.setLastName("singh");
		studentdao.updateLastName(myStudent);
		System.out.println("updated student:"+myStudent);
	}

	private void queryForStudentsByLastName(StudentDao studentdao) {
		List<Student> theStudents=studentdao.findByLastName("devaraj");
		for(Student s: theStudents)
		{
			System.out.println(s);
		}
	}

	private void queryForStudents(StudentDao studentdao) {
		List<Student> students=studentdao.findAll();
		for(Student s: students)
		{
			System.out.println(s);
		}
	}

	private void readStudent(StudentDao studentdao) {
		Student student= new Student("preethi","devaraj","preethi@coolie.com");
		studentdao.save(student);
		int theid=student.getId();
		System.out.println("Id of the saved student:"+theid );
		System.out.println("retrievingg");
		Student myStudent=studentdao.findById(Integer.valueOf(theid));
		System.out.println("found"+ myStudent);
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
