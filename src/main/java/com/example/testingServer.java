package com.example;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testingServer {
    private static int port = 8080;
    private static int poolNumber = 10;
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(poolNumber);

        try(ServerSocket server = new ServerSocket(port)){
            Socket client = server.accept();
            pool.submit(new Testingclienthandle(client));


        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        
    }
    
}
