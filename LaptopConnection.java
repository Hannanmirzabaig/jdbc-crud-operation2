package com.jsp.jdbc_prepared_statement.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;

public class LaptopConnection {
	
	public static Connection getLaptopConnection() {
		
			
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		String url="jdbc:mysql://localhost:3306/jdbc_10am";
		String user="root";
		String pass="root";
		return DriverManager.getConnection(url,user,pass);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;

}
}
