package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UrlRewriteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sessionID = "12345";  // Simulate a session ID
        String url = response.encodeURL("http://example.com/welcome?session=" + sessionID);  // Encode the URL with session ID
        response.getWriter().write("Session ID added to URL: " + url);
    }
}
