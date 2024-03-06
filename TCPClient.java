package com.NetworkProgramming;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost"; // Server's IP address or hostname
        final int SERVER_PORT = 3306; // Port the server is listening on

        try {
            // Connect to the server
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to server on port " + SERVER_PORT);

            // Create input and output streams for communication with the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Send messages to the server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String userInputLine;
            while ((userInputLine = userInput.readLine()) != null) {
                writer.println(userInputLine); // Send the message to the server
                System.out.println("Server response: " + reader.readLine()); // Print the server's response
            }

            // Close the streams and socket when done
            userInput.close();
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
