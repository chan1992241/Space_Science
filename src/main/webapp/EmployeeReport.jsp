<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 18/8/2022
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Report</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1>Employee Report</h1>
<%
    List<String> map = (List<String>) request.getAttribute("RESULTS");
%>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Description</th>
        <th scope="col">Figures</th>
    </tr>
    </thead>
    <tbody>
    <%
        int i = 0;
        for (String c : map) {
        i++;
        String[] s = c.split(":");
    %>
    <tr>
        <th scope="row"><%=i%></th>
        <td><%=s[0]%>
        </td>
        <td><%=s[1]%>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
