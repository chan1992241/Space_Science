package com.example.EmployeeWebApp.controller;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegistrationController", value = "/RegistrationController")
public class RegistrationController extends HttpServlet {
//    private int counter;
//    private String images[] = {"p1.png", "p2.png", "p3.png", "p4.png"};
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        response.setHeader("Refresh", "5");
//        String fname = request.getParameter("fname");
//        String lname = request.getParameter("lname");
//        String address = request.getParameter("address");
//        String gender = request.getParameter("gender");
//        String[] qualification = request.getParameterValues("qualification"); // Can get more than one values
//        String race = request.getParameter("race");
//        String intro = request.getParameter("intro");
////Do the same for other inputs; be careful to get
//        if (fname.isEmpty() || lname.isEmpty() || address.isEmpty() || gender.equals("empty") ||
//                qualification[0].equals("empty") || race.equals("Select") || intro.trim().length() == 0) {
//            out.println("<SCRIPT type=\"text/javascript\">");
//            out.println("alert(\"Incomplete input you will be redirected to index.html\")");
//            out.println("window.location.assign(\"index.html\")");
//            out.println("</SCRIPT>");
//        } else {
//            if (counter == 4) {
//                counter = 0;
//            }
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Register</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<div style= \"margin-left: 400px;margin-top: 200px; background-color: #ffcccc; width:30%\">");
//            out.println("<h2>You entered the following data</h2>");
//            out.println("<p>");
//            out.println("First Name: " + fname);
//            out.println("<br>");
//            out.println("<br>");
//            out.println("Last Name: " + lname);
//            out.println("<br>");
//            out.println("Address: " + address);
//            out.println("<br>");
//            out.println("Gender: " + gender);
//            out.println("<br>");
//            out.println("Race: " + race);
//            out.println("<br>");
//            out.println("Qualification:");
//            for(int i = 0; i < qualification.length; i++)
//            {
//                out.println(qualification[i]);
//                out.println("<br>");
//            }
//            out.println("Self-Introduction ");
//            out.println("</p>");
//            out.println("<FORM METHOD=\"POST\" ACTION=\"DisplayRegInfo\">");
//            out.println("<INPUT TYPE=hidden NAME=\"firstname\" VALUE=\"" + fname + "\">");
//            out.println("<INPUT TYPE=hidden NAME=\"lastname\" VALUE=\"" + lname + "\">");
//            out.println("<BR><INPUT TYPE=submit value=\"Confirm\">");
//            out.println("</FORM>");
//            out.println("<img WIDTH=150 HEIGHT=100 src=\"" + "images" + "/" + images[counter] + "\"/>");
//            counter = counter + 1;
//            out.println("</div>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("confirm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
