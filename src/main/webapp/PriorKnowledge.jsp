<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28/7/2022
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Space-Science</title>
</head>
<body>
<h1>PriorKnowledge</h1>
<%
        String location = request.getParameter("location");
//        out.println("You chose " + location);
//        out.println("<br><br>");
//        out.println("<a href=\"" + "display.jsp?location=" + location + "&knowledge=diploma" + "\">Diploma</a>");
//        out.println("<a href=\"" + "display.jsp?location=" + location + "&knowledge=bachelor" + "\">Bachelor</a>");
        out.println("<FORM METHOD=\"GET\"ACTION=\"display.jsp\">");
        out.println("<BR>Now enter your prior qualification: ");
        out.println("<INPUT TYPE =text NAME=\"knowledge\">");
// However, we also want to keep track of which user is on the system
        out.println("<INPUT TYPE=hidden NAME=\"location\" VALUE=\"" + location + "\">");
        out.println("<BR><BR><INPUT TYPE=submit value=\"Submit Form\">");
        out.println("</form>");
%>
</body>
</html>
