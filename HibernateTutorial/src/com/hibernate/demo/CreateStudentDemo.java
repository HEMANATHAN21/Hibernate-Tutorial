package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.demo.Student;
import com.hibernate.entity.demo.*;
public class CreateStudentDemo 
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
			Student stud = new Student(1,"hema", "hema@gmail.com", 1234);
			
			//start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student");
			session.save(stud);
			
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
