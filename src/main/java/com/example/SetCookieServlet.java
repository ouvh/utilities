package com.example;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("sessionToken", "abcd1234");
        response.addCookie(cookie); // Add the cookie to the response
        response.getWriter().write("<h1>the oprations is done</h1>");
    }
}
