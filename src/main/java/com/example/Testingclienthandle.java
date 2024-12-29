package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Testingclienthandle implements Runnable{
    private Socket client;

    public Testingclienthandle(Socket socket){
        client = socket;
    }

    @Override
    public void run(){

        try(PrintWriter out = new PrintWriter(client.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))){

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




        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }

    }


    
}
