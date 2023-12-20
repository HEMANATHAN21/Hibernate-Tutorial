package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.demo.Student;

public class PrimaryKeyDemo 
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
			System.out.println("Creating 3 new student object");
			Student stud1 = new Student("varshan", "varshan@gmail.com", 1234);
			Student stud2 = new Student("solo", "solo@gmail.com", 1234);
			Student stud3 = new Student("hari", "hari@gmail.com", 1234);
					
			//start transaction
			session.beginTransaction();
					
			//save the student object
			System.out.println("Saving the student");
			session.save(stud1);
			session.save(stud2);
			session.save(stud3);
					
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
