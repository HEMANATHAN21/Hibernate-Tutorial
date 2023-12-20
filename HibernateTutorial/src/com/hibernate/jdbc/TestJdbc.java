package com.hibernate.jdbc;
import java.sql.*;
public class TestJdbc 
{	
	public static void main(String[] args) 
	{
		try
		{
			String jdbcurl = "jdbc:mysql://localhost:3306/hibernate?user=root&password=solohema";
			System.out.println("Connecting to Database..");
			Connection con = DriverManager.getConnection(jdbcurl);
			System.out.println("Connected Successfully..");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
