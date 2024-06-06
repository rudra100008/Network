package com.company.Network_Program;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class ReadWriteServer {
public static void main(String[] args) throws Exception {
	ServerSocket server=new ServerSocket(9090);
	Socket serverSocket=server.accept();
	DataInputStream in=new DataInputStream(serverSocket.getInputStream());
	DataOutputStream out=new DataOutputStream(serverSocket.getOutputStream());
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	String str="",str1="";
	while(!str.equals("stop")) {
		str=in.readUTF();
		System.out.println("In ServerSide:");
		System.out.println("Client Says: "+str);
		str1=br.readLine();
		out.writeUTF(str1);
		out.flush();
	}
	out.close();
	serverSocket.close();
	server.close();
}
}
