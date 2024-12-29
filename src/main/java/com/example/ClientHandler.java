package com.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket client;


    public ClientHandler(Socket socket) {
        this.client = socket;
    } 

    public void run() {

        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
            
            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received from client: " + clientMessage);
                if ("How are you?".equals(clientMessage)) {
                    out.println("I am fine, thank you!");
                }
                else{
                    out.println("you typed the wrong question");
                }

                
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    
    }

    
}
