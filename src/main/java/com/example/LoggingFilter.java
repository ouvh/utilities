package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;



public class LoggingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        long startTime = System.currentTimeMillis();  // Track the start time
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("Request URL: " + httpRequest.getRequestURL());

        chain.doFilter(request, response);  // Continue with the request-response cycle
        
        long endTime = System.currentTimeMillis();  // Track the end time
        System.out.println("Time taken to process: " + (endTime - startTime) + "ms");
    }
    public void destroy() {}
}

