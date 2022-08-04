<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/8/2022
  Time: 8:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Confirmation Page</title>
</head>
<body>
<h1>Java Bean Approach</h1>
<%--<%--%>
<%--        String fname = request.getParameter("fname");--%>
<%--        String lname = request.getParameter("lname");--%>
<%--        String address = request.getParameter("address");--%>
<%--        String gender = request.getParameter("gender");--%>
<%--        String[] qualification = request.getParameterValues("qualification"); // Can get more than one values--%>
<%--        String race = request.getParameter("race");--%>
<%--        String intro = request.getParameter("intro");--%>
<%--//Do the same for other inputs; be careful to get--%>
<%--        if (fname.isEmpty() || lname.isEmpty() || address.isEmpty() || gender.equals("empty") ||--%>
<%--                qualification[0].equals("empty") || race.equals("Select") || intro.trim().length() == 0) {--%>
<%--            session.invalidate();--%>
<%--            out.println("<SCRIPT type=\"text/javascript\">");--%>
<%--            out.println("alert(\"Incomplete input you will be redirected to index.html\")");--%>
<%--            out.println("window.location.assign(\"index.html\")");--%>
<%--            out.println("</SCRIPT>");--%>
<%--        } else {--%>
<%--%>--%>

<jsp:useBean id = "reg1" class="com.example.EmployeeWebApp.Model.javabean.RegisterInfo" scope="session"/>
<jsp:setProperty name="reg1" property="fname"/>
<jsp:setProperty name="reg1" property="lname"/>
<jsp:setProperty name="reg1" property="race"/>
<jsp:setProperty name="reg1" property="address"/>
<jsp:setProperty name="reg1" property="gender"/>
<jsp:setProperty name="reg1" property="intro"/>
<jsp:setProperty name="reg1" property="qualification" value='<%=request.getParameterValues("qualification")%>'/>

<%--<jsp:getProperty name="reg1" property="fname"/>--%>
<jsp:forward page="RegistrationController"/>
<%--<%--%>
<%--    }--%>
<%--%>--%>
</body>
</html>
