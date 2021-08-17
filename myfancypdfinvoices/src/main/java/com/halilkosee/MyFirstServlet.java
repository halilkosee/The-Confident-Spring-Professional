package com.halilkosee;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(
                "<html>\n" +
                "<body>\n" +
                "<h1>Hello World</h1>\n" +
                "<p>This is my first, embedded Tomcat, HTML Page!</p>\n" +
                "</body>\n" +
                "</html>");
    }
}
