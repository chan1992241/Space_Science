package com.example.EmployeeWebApp.controller;

import com.example.EmployeeWebApp.utilities.AptitudeChecker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import static com.example.EmployeeWebApp.utilities.AptitudeChecker.calculateScore;
import static java.lang.System.out;

@WebServlet(name = "Aptitude", value = "/Aptitude", urlPatterns = {"/Aptitude", "/apt"})
public class Aptitude extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//Declare a local variable and set it with zero
        String anw1 = request.getParameter("Answer1");
        String anw2 = request.getParameter("Answer2");
        String anw3 = request.getParameter("Answer3");
        String anw4 = request.getParameter("Answer4");
        String anw5 = request.getParameter("Answer5");
        int totalcorrectansw = 0;
//Declare some variables for Answer 4 and Answer 5
//        PrintWriter out = response.getWriter();
        if (anw1.equals("empty") || anw2.equals("empty") || anw3.equals("empty") || anw4.equals("empty") ||
                anw5.equals("empty")) {
            out.println("<SCRIPT type=\"text/javascript\">");
            out.println("alert(\"Incomplete input you will be redirected to index.html\")");
            out.println("window.location.assign(\"index.html\")");
            out.println("</SCRIPT>");
        } else {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet servlet1</title>");
//            out.println("</head>");
//            out.println("<body>");
//            if (anw1.equals("30")) {
//                totalcorrectansw = totalcorrectansw + 1;
//            }
//            if (anw2.equals("12"))
//            { totalcorrectansw = totalcorrectansw + 1; }
//            if (anw3.equals("720"))
//            {totalcorrectansw = totalcorrectansw + 1; }
//            if (anw4.equals("8"))
//            { totalcorrectansw = totalcorrectansw + 1; }
//            if (anw5.equals("48"))
//            { totalcorrectansw = totalcorrectansw + 1; }
            String results[] = {anw1,anw2,anw3,anw4,anw5};
//            totalcorrectansw = AptitudeChecker.calculateScore(results);
//            request.setAttribute("RESULTS", results);
//            request.setAttribute("FINALRES", totalcorrectansw);
//            RequestDispatcher req = request.getRequestDispatcher("display.jsp");
//            req.forward(request, response);
            totalcorrectansw = AptitudeChecker.calculateScore(results);
            HttpSession session = request.getSession();
            session.setAttribute("RESULTS", results);
            session.setAttribute("FINALRES", totalcorrectansw);
            RequestDispatcher req = request.getRequestDispatcher("Location.jsp");
            req.forward(request, response);
//            out.println("<div style= \"margin-left: 400px;margin-top: 200px; background-color: #ffcccc; width:30%\">");
//            out.println("Your answer:");
//            out.println("<br>Answer 1: " + anw1);
//            out.println("<br>Answer 2: " + anw2);
//            out.println("<br>Answer 3: " + anw3);
//            out.println("<br>Answer 4: " + anw4);
//            out.println("<br>Answer 5: " + anw5);
//Display the output for the rest of the answers....
//Next develop a simple if/else structure to determine if a learner has passed or failed the test.....
//            if(totalcorrectansw >= 3)
//                What is exactly this line for???
//            Annotation???
//            What is this line for???
//            What is happening here???
//            Repeat this for other answers…
//            Observe the following commented
//            statement
//            Repeat this for other answers…
//            Observe Figure 5
//            5 answers from users
//            so, create 5 variables to store each of them,
//            but why data type is String and not integer???
//            Create two more variables  anw4 and anw5
//            UCCD3243 Server-Side Web Application Development Practical Session 1
//            Prepared by: Ts. Dr Anbuselvan S Page 11 of 14
//            {
//                out.println("<br><br>Your score is " + " " + totalcorrectansw + " " + "over 5");
//                out.println("<br>You have passed the test");
//            }else
//            {
//                out.println("<br><br>Your score is " + " " + totalcorrectansw + " " + "over 5");
//                out.println("<br>You have failed the test");
//            }
//            out.println("</div>");
//            out.println("</body>");
//            out.println("</html>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
