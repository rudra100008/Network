package com.company.Network_Program;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MultiClient {
	public static void main(String[] args)throws Exception {
		String hostname="localhost";
		int port=9090;
		Socket socket=new Socket(hostname,port);
		DataOutputStream out=new DataOutputStream(socket.getOutputStream());
		DataInputStream in=new DataInputStream(socket.getInputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String text;
		do {
			System.out.println("Enter a text");
			text=br.readLine();
			out.writeUTF("Client says: "+text);
			
			String text1=in.readUTF();
			System.out.println(text1);
			
		}while(!text.equals("exit"));
		socket.close();
	}

}
