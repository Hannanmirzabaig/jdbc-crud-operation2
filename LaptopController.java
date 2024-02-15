package com.jsp.jdbc_prepared_statement.controller;
import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

import com.jsp.jdbc_prepared_statement.connection.LaptopConnection;
import com.jsp.jdbc_prepared_statement.entity.Laptop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LaptopController {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection connection=null;
		while(true) {
			System.out.println(" 1-INSERT\n 2-DELETE\n 3-UPDATE\n 4-DISPLAY");
			System.out.println("enter the option");
			int option=sc.nextInt();
			
			switch(option) {
			case 1:{
				connection =LaptopConnection.getLaptopConnection();
				System.out.println("enter the id");
				int id=sc.nextInt();
				
				System.out.println("enter the  name");
				String name=sc.next();
				
				System.out.println("enter the  color");
				String color=sc.next();
				
				System.out.println("enter the price");
				double price=sc.nextDouble();
				System.out.println("enter the  ram");
				String ram=sc.next();
				
				Laptop laptop=new Laptop(id,name,color,price,ram);
				
				String insertQuery="insert into laptop values(?,?,?,?,?)";
				
				try {
					PreparedStatement ps=connection.prepareStatement(insertQuery);
					 ps.setInt(1,laptop.getId());
					 ps.setString(2, laptop.getName());
					 ps.setString(3, laptop.getColor());
					 ps.setDouble(4, laptop.getPrice());
					 ps.setString(5, laptop.getRam());
					 
					 ps.execute();
					 System.out.println("data stored");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
				break;
				
			case 2:{
				connection =LaptopConnection.getLaptopConnection();
				System.out.println("enter the id");
				int id=sc.nextInt();
				
			String deleteQuery="delete from laptop where id=?";
			
			try {
				PreparedStatement ps=connection.prepareStatement(deleteQuery);
				ps.setInt(1, id);
				int i=ps.executeUpdate();
				if(i>0) {
					System.out.println("successfully deleted");
				}
				else {
					System.out.println("id not found");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
				break;
				
			case 3:{
				
				System.out.println("what you want to update......");
				System.out.println("1- name \n 2-color \n 3-price\n 4-name,price,color,ram");
				int choicee=sc.nextInt();
				
				switch(choicee) {
				case 1:{
					System.out.println("enter the id to update name");
					int id=sc.nextInt();
					
					System.out.println("enter the new laptop name ");
					String name=sc.next();
					
					String updateNameQuery="update laptop set name=? where id=?";
					
					connection=LaptopConnection.getLaptopConnection();
					try {
						PreparedStatement ps=connection.prepareStatement(updateNameQuery);
						ps.setInt(2, id);
						ps.setString(1, name);
						int i=ps.executeUpdate();
						if(i>0) {
							System.out.println("successfully update");
						}
						else {
							System.out.println("failed");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				break;
				
				case 2:{
					System.out.println("enter the id to update name");
					int id=sc.nextInt();
					
					System.out.println("enter the new laptop color ");
					String color=sc.next();
					
					connection=LaptopConnection.getLaptopConnection();
					
					String updateColorQuery="update laptop set color=? where id=?";
					
					try {
						PreparedStatement ps=connection.prepareStatement(updateColorQuery);
						ps.setInt(2, id);
						ps.setString(1,color);
						int i=ps.executeUpdate();
						if(i>0) {
							System.out.println("successfully color update");
						}else {
							System.out.println("id not found");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				}
				break;
				
				case 3:{
					System.out.println("enter the id to update price");
				int id=sc.nextInt();
				
				System.out.println("enter the new laptop price ");
				double price=sc.nextDouble();
				
				connection=LaptopConnection.getLaptopConnection();
				
				String updatePriceQuery="update laptop set price=? where id=?";
				
				try {
					PreparedStatement ps=connection.prepareStatement(updatePriceQuery);
					ps.setInt(2, id);
					ps.setDouble(1, price);
					int i=ps.executeUpdate();
					if( i>0) {	
						System.out.println("successfully update");
						}else {
							System.out.println("id not fount");
						}
					}
					catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					
				}break;
				
				case 4:{
					System.out.println("enter the id to update the name,color,price and ram");
					int id=sc.nextInt();
					System.out.println("enter the new name");
					String name=sc.next();
					System.out.println("enter the new color");
					String color=sc.next();
					System.out.println("enter the new Price");
					double price=sc.nextDouble();
					System.out.println("enter the new ram");
					String ram=sc.next();
					
					connection=LaptopConnection.getLaptopConnection();
					
					String updateQuery="update laptop set name=?,color=?,price=?,ram=? where id=?";
					
					try {
						PreparedStatement ps=connection.prepareStatement(updateQuery);
						ps.setInt(5, id);
						ps.setString(1, name);
						ps.setString(2,color);
						ps.setDouble(3, price);
						ps.setString(4, ram);
						
						int i=ps.executeUpdate();
						
						if(i>0) {
							
							System.out.println("successfully update");
						}
						else {
							System.out.println("id not found");
						}
								
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally {
						try {
							connection.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
					
				}break;
				default:
				}
				
				
			}
				break;
			case 4:{
				connection=LaptopConnection.getLaptopConnection();
				
				String displayQuery="select * from laptop";
				
				try {
					PreparedStatement ps=connection.prepareStatement(displayQuery);
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
						int id=rs.getInt("id");
						String name=rs.getString("name");
						String color=rs.getString("color");
						double price=rs.getDouble("price");
						String ram=rs.getString("ram");
						
						System.out.println("[id is : "+id+" ] , [ name is : "+name+" ] , [  color is : "+color+" ] , [ price is : "+price+" ] , [ ram is : "+ram+"]");
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				break;
			
			
			default:System.out.println("enter valid  option");
			}
			
		}
		
	}
}



