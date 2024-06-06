package com.company.Network_Program;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadWriteClient {
public static void main(String[] args)throws Exception {
	
	Socket clientSocket=new Socket("localhost",9090);
	DataOutputStream out=new DataOutputStream(clientSocket.getOutputStream());
	DataInputStream in=new DataInputStream(clientSocket.getInputStream());
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	String str="",str1="";
	while(!str.equals("stop")) {
		str=br.readLine();
		out.writeUTF(str);
		out.flush();
		 str1=in.readUTF();
		 System.out.println("In client side:");
		 System.out.println("Server says: "+str1);
	}
	out.close();
	clientSocket.close();
}
}
