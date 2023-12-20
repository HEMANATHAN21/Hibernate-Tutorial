package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.demo.Student;
import com.hibernate.entity.demo.*;
public class QueryStudentDemo 
{
	public static void main(String[] args) 
	{
		//Create SessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		
		try
		{
			//start transaction
			session.beginTransaction();
			
			//query students
			List<Student> studentslist = session.createQuery("from Student").list();
			
			//display the students
			displayStudents(studentslist);
			
			//query students 
			studentslist = session.createQuery("from Student s where s.contact=12345678").list();
			
			//display the students
			System.out.println("\n\nDisplay students List Whos Contact No Is 12345678");
			displayStudents(studentslist);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done..");
		}
		finally
		{
			factory.close();
		}
	}

	private static void displayStudents(List<Student> studentslist) {
		for (Student student : studentslist) 
		{
			System.out.println(student);
		}
	}
}
