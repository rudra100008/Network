package com.company.Network_Program;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiCLientServer {
public static void main(String[] args)throws Exception {
	int port=9090;
	ServerSocket server=new ServerSocket(port);
	System.out.println("Connected to "+port+".........");
	Socket serverSocket=server.accept();
	System.out.println("New Client Connected......");
	
	
	new ClientHandler(serverSocket).start();
}
}

class ClientHandler extends Thread{
	private Socket socket;
	
	public ClientHandler(Socket socket) {
		this.socket =socket;
	}
	public void run(){
		try {
			DataInputStream in=new DataInputStream(socket.getInputStream());
			DataOutputStream out=new DataOutputStream(socket.getOutputStream());
			
			String text;
			do {
				text=in.readUTF();
				
				out.writeUTF("Sever says: "+text);
			}while(!text.equals("exit"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
			socket.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
