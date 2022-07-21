package com.example.EmployeeWebApp.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DisplayRegInfo", value = "/DisplayRegInfo")
public class DisplayRegInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Display Registration Results</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div style= \"margin-left: 400px;margin-top: 200px; background-color: #ffcccc; width:30%\">");
//Write some codes here to display the output….
            out.println("<h2>Welcome aboard " + request.getParameter("firstname") + " " + request.getParameter("lastname") + "</h2>");
            out.println("<h3>Your Registration Is Success</h3>");
            RequestDispatcher rd= request.getRequestDispatcher("/navigation_link.html");
            rd.include(request, response);
            out.println("<br>");
            out.println("<h4>Should you need technical support, contact us via email or phone</h4>" );
            out.println("Email: " + " " + request.getServletContext().getInitParameter("Email"));
            out.println("&nbsp;&nbsp;Phone: " + " " + request.getServletContext().getInitParameter("Phone"));
            out.println("</div");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
