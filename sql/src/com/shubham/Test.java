package com.shubham;

import java.sql.*;
public class Test {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("First line executed");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","shubham");
	System.out.println("Connection Successfull");
	Statement stmt=con.createStatement(); 
	System.out.println("Statement three done");
	ResultSet rs=stmt.executeQuery("select * from studenttab");
	
	while(rs.next())  
		System.out.println(rs.getString(3));
	con.close();
}
}
