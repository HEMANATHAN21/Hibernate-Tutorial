package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.demo.Student;
import com.hibernate.entity.demo.*;
public class DeleteStudentDemo 
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
			int studentId = 5;
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrive student based on id : primary key
		//	System.out.println("\n Getting student with id : "+studentId);
			
			//Student mystudent = session.get(Student.class, studentId);
			
			//System.out.println("Deleting student record : "+mystudent);
			
			//delete the student
			//session.delete(mystudent);
			
			//delete student id =4
			System.out.println("Delete student record id = 4");
			session.createQuery("delete from Student where id = 4").executeUpdate();
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
