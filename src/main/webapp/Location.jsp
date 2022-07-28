<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28/7/2022
  Time: 8:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Location</h1>
<h2>Choose appropriate Location</h2>
<br><br>
<%--<a href="PriorKnowledge.jsp?location=Klang Valley">Klang Valley Area</a>--%>
<%--<a href="PriorKnowledge.jsp?location=Non Klang Valley">Non Klang Valley Area</a>--%>
<form action="PriorKnowledge.jsp">
    Location <input type="text" name="location" value="" />
    <input type="submit" value="Next" />
</form>
</body>
</html>
