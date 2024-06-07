package com.company.Network_Program.Form;

public class Employee {
	private int id;
	private String name;
	private String phoneNumber;
	
	public Employee(int id,String name,String phoneNumber) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.phoneNumber=phoneNumber;
	}
	public int getId() {return this.id;}
	public String getName() {return this.name;}
	public String getPhone() {return this.phoneNumber;}
	
	
	public void setId(int id) {this.id=id;}
	public void setName(String name) {this.name=name;}
	public void setPhone(String phoneNumber) {this.phoneNumber=phoneNumber;}

}
