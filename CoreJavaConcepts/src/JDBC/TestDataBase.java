package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDataBase
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcdb","postgres","admin");
			System.out.println("Connection Established...");
			Statement s = con.createStatement();
			s.executeQuery("create table Student(Rollno number(3) primary key, Name varchar(30), Address varchar(30), PhoneNo number(10) )");
			con.close();
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
