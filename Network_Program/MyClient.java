package com.company.Network_Program;

import java.io.DataOutputStream;
import java.net.Socket;

public class MyClient {
public static void main(String[] args) {
	try {
		Socket inputSocket=new Socket("localhost",9090);
		DataOutputStream output=new DataOutputStream(inputSocket.getOutputStream());
		output.writeUTF("Hello Server");
		output.flush();
		output.close();
	    inputSocket.close();
	}catch(Exception e) {
		System.out.println("Error: "+e.getMessage());
	}
}
}
