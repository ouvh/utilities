package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;



public class EmbeddedJettyServer {
    public static void main(String[] args) throws Exception {
        // Create a Jetty server on port 8080
       Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // setting endpoints here -->
        context.addServlet(new ServletHolder(new SetCookieServlet()), "/cookie"); 
        context.addServlet(new ServletHolder(new UrlRewriteServlet()), "/urlrewrite"); 
        context.addFilter(new FilterHolder(new LoggingFilter()), "/*", null);

        server.start(); 
        server.join(); 
        
    }
}
