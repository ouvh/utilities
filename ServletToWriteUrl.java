package com.test;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class ServletToWriteUrl extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       HttpSession session = req.getSession();
       
       String sessionId = session.getId();
       
       resp.setContentType("text/html");
       
       String urlSession = req.getRequestURL().toString() + "?sessionId=" + sessionId;
       
       resp.getWriter().println("<h4>Hello from MyServlet! Your URL with session ID is: " + urlSession + "</h4>");
   }
}
