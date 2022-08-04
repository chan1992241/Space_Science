<%@ page import="com.example.EmployeeWebApp.Model.javabean.RegisterInfo" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/8/2022
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<%
    RegisterInfo r = (RegisterInfo) session.getAttribute("reg1");
out.println("<div style= \"margin-left: 400px;margin-top: 200px; background-color: #ffcccc; width:30%\">");
out.println("<h2>Welcome aboard " + r.getFname() + " " + r.getLname() + "</h2>");
out.println("<h3>Your Registration Is Success</h3>");
%>
<jsp:include page="navigation_link.html"/>
<%--RequestDispatcher rd= request.getRequestDispatcher("/navigation_link.html");--%>
<%--rd.include(request, response);--%>
<%
out.println("<br>");
out.println("<h4>Should you need technical support, contact us via email or phone</h4>" );
out.println("Email: " + " " + request.getServletContext().getInitParameter("Email"));
out.println("&nbsp;&nbsp;Phone: " + " " + request.getServletContext().getInitParameter("Phone"));
out.println("</div");
%>
</body>
</html>
