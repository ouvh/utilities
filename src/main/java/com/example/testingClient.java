package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class testingClient {
    private static String serverUrl = "localhost";
    private static int serverPort = 8080;

    public static void main(String[] args) {
        

        try(Socket socket = new Socket(serverUrl,serverPort);
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ){

            out.println("How are you?");  // Send message to server
            String response = in.readLine();  // Read server's response
            System.out.println("Server response: " + response);
            out.println("take this?");  // Send message to server
            System.out.println("Server response: " + in.readLine());



        }catch( Exception e){
            System.err.println(e.getMessage());
        }
    }
}
