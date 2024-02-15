package com.jsp.jdbc_prepared_statement.entity;


/**
 * @author Abdul Hannan Mirza
 */

public class Laptop {
	private int id;
	private String name;
	private String color;
	private double price;
	private String ram;
	
	public Laptop(){
		
	}
	public Laptop(int id,String name,String color,double price,String ram){
		this.id=id;
		this.name=name;
		this.color=color;
		this.price=price;
		this.ram=ram;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getColor() {
		return color;
	}
	public double getPrice() {
		return price;
	}
	public String getRam() {
		return ram;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	@Override// alt+shift+ss+a
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", ram=" + ram;
				
	}
	
	
	
	

}
