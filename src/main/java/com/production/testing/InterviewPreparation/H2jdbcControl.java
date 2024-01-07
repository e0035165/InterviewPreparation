package com.production.testing.InterviewPreparation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class H2jdbcControl {
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";  
	   
   //  Database credentials 
   static final String USER = "sa"; 
   static final String PASS = "";
   Connection conn = null;
   Statement stmt = null;
   
   public H2jdbcControl()
   {
	   try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connection is successful");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
   }
   
//   public static void main(String... strings)
//   {
//	   H2jdbcControl controller = new H2jdbcControl();
//   }
   public void insertQuery(String insertqry, List<Object> lst)
   {
	   try {
		if(!conn.isClosed())
		   {
			   
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
