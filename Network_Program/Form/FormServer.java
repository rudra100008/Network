package com.company.Network_Program.Form;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.ServerSocket;
import java.net.Socket;

public class FormServer {
	
   public static void main(String[] args)throws Exception {
	   try {
		   
	   
	ServerSocket server=new ServerSocket(9090);
	Socket serverSocket=server.accept();
	DataOutputStream out=new DataOutputStream(serverSocket.getOutputStream());
	DataInputStream in=new DataInputStream(serverSocket.getInputStream());
	
	boolean isExit=false;
	while(!isExit) {
		int id=in.readInt();
		String name=in.readUTF();
		String phoneNumber=in.readUTF();
		System.out.println("ID: "+id+"\nName: "+name+"\nPhoneNumber: "+phoneNumber);
		out.flush();
		if ( name==null ) {
			isExit=true;
		}else {
			out.writeUTF("Data Received Sucessfully........");
		}
	}
	out.close();
	in.close();
	serverSocket.close();
	server.close();
	}catch (EOFException e) {
		System.out.println("Client disConnected........");
	}
	
	
	
   }
}
