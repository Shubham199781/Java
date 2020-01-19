package com.shubham.cliniqueManagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class DoctorManagement {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		/* Registering Driver Class */
		Class.forName("com.mysql.cj.jdbc.Driver");
		
        System.out.println("Enter Username");
        String userName=br.readLine();
        
        System.out.println("Enter password");
        String password=br.readLine();
        
        String path="jdbc:mysql://localhost:3306/doctors";
        /*Create Connection*/
        Connection con=DriverManager.getConnection(path, userName, password);
        
        /*Create statement object*/
        Statement stmt=con.createStatement();
        
        /*Created IDoctorImp Class object*/
        IDoctorImp i=new IDoctorImp();
       
        System.out.println("Welcome to doctor table");
        
        while(true)
        {
        	System.out.println("Enter 1 to start else press 0 to exit");
        	int option=Integer.parseInt(br.readLine());
        	if(option==1)
        		i.manager(br, con, stmt);
        	else
        		if(option==0)
        			{
        			System.out.println("Exit");
        			break;
        			}
        		else
        			System.out.println("Entered wrong option");
        }
       }

}
