package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.demo.Student;
import com.hibernate.entity.demo.*;
public class UpdateStudentDemo 
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
			int studentId = 1;
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrive student based on id : primary key
			System.out.println("\n Getting student with id : "+studentId);
			
			Student mystudent = session.get(Student.class, studentId);
			
			System.out.println(mystudent);
			
			System.out.println("Updating Students...");
			mystudent.setEmail("solo@gmail.com");
			
			
			//new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("Update email for all students...");
			session.createQuery("update Student set email = 'abc@gmail.com'").executeUpdate();
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
