package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.demo.Student;
import com.hibernate.entity.demo.*;
public class ReadStudentDemo 
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
			//create Student object
			System.out.println("Creating new student object");
			Student stud = new Student("purus", "purus@gmail.com", 1234);
			
			//start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student");
			System.out.println(stud);
			session.save(stud);
			
			//commit the transaction
			session.getTransaction().commit();
			
			//find out student id : primary key
			System.out.println("Saved Student Generated id Is : "+stud.getId());
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrive student based on id : primary key
			System.out.println("\n Getting student with id : "+stud.getId());
			
			Student mystudent = session.get(Student.class, stud.getId());
			
			System.out.println("Get Complete : "+mystudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done..");
		}
		finally
		{
			factory.close();
		}
	}
}
