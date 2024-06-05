package com.company.Network_Program;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer 
{
	public static void main(String[] args) {
		try {
			ServerSocket ss=new ServerSocket(9090);
			Socket s=ss.accept();
			DataInputStream input=new DataInputStream(s.getInputStream());
			String message=(String) input.readUTF();
			System.out.println("Message from Client: "+message);
			ss.close();
		}catch(Exception e){
			System.out.println("ERROR: "+e.getMessage());
		}
	}

}
