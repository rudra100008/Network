package com.NetworkProgramming;

import java.io.*;
import java.net.*;

public class MultiThreadTCP {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3306); // Server socket listening on port 9999
            System.out.println("Server started. Listening on port 9999...");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept incoming client connections

                // Start a new thread to handle each client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;

            // Read messages from the client and echo them back
            while ((inputLine = reader.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);
                writer.println("Echo: " + inputLine);
            }

            // Close streams and sockets when done
            reader.close();
            writer.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
