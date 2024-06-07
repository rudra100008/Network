package com.company.Network_Program.Form;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;


public class FormClient {
	
	public static void main(String[] args) throws Exception{
		ArrayList<Employee> array=new ArrayList<Employee>();
		Socket clientSocket=new Socket("localhost",9090);
		DataOutputStream out=new DataOutputStream(clientSocket.getOutputStream());
		DataInputStream in=new DataInputStream(clientSocket.getInputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String exit="";
		while(!exit.equals("e")) {
			System.out.println("Enter the id of employee: ");
			int id=Integer.parseInt(br.readLine());
			
			System.out.println("Enter the name of Employee: ");
			String name=br.readLine();
			
			System.out.println("Enter the phone number of Employee: ");
			String phoneNumber=br.readLine();
			
			Employee employee=new Employee(id, name, phoneNumber);
			array.add(employee);
			
			
			System.out.println("Enter e to exit and c to continue:");
			exit=br.readLine();
		}
		for(Employee employee:array) {
			out.writeInt(employee.getId());
			out.writeUTF(employee.getName());
			out.writeUTF(employee.getPhone());
		}
	String str=in.readUTF();
	System.out.println("Server says: "+str);
	out.flush();
	out.close();
	in.close();
	clientSocket.close();
		
	}

}
