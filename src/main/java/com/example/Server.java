package com.example;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.*;

public class Server{
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);


        try(ServerSocket serverSocket = new ServerSocket(8000)){
            System.out.println(" the server is running on localhost:8080");
            
            while(true){
                Socket client = serverSocket.accept();
                System.out.println("new client is connected");

                pool.submit(new ClientHandler(client));

            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        };

    }

}