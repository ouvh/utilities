package com.example;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 8000);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("How are you?");  // Send message to server
            String response = in.readLine();  // Read server's response
            System.out.println("Server response: " + response);
            out.println("take this?");  // Send message to server
            System.out.println("Server response: " + in.readLine());


            
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
