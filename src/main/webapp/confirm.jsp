<%@ page import="com.example.EmployeeWebApp.Model.javabean.RegisterInfo" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/8/2022
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Confirmation</title>
</head>
<body>
<h2>You entered the following data</h2>
<%!
    private int counter;
    private String images[] = {"p1.png", "p2.png", "p3.png", "p4.png"};
%>
<%
    response.setHeader("Refresh", "5");
    RegisterInfo r = (RegisterInfo) session.getAttribute("reg1");
    if (counter == 4) {
    counter = 0;
    }
    out.println("<p>");
    out.println("First Name: " + r.getFname());
    out.println("<br>");
    out.println("Last Name: " + r.getLname());
    out.println("<br>");
    out.println("Address: " + r.getAddress());
    out.println("<br>");
    out.println("Gender: " + r.getGender());
    out.println("<br>");
    out.println("Race: " + r.getRace());
    out.println("<br>");
    out.println("Qualification:");
    for (int i = 0; i < r.getQualification().length; i++) {
    out.println(r.getQualification()[i] + " ");
    }
    out.println("<br>");
    out.println("Self-Introduction ");
    out.println("<br>" + r.getIntro());
    out.println("</p>");
    out.println("<img WIDTH=150 HEIGHT=100 src=\"" + "images" + "/" + images[counter] + "\"/>");
    counter = counter + 1;
%>
<form method="post" action="DisplayRegInfo.jsp">
    <br><input type="submit" value="Confirm"/>
</form>
%>
</body>
</html>
