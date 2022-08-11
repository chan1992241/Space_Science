package com.example.EmployeeWebApp.controller;

import com.example.EmployeeWebApp.Model.entity.Employee;
import com.example.EmployeeWebApp.Model.managedbean.EmployeeService;
import com.example.EmployeeWebApp.Model.sessionbean.EmployeeSessionBeanLocal;
import com.example.EmployeeWebApp.utilities.LoggingGeneral;
import com.example.EmployeeWebApp.utilities.ValidateManageLogic;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private EmployeeSessionBeanLocal empbean;
//    @Inject
//    private EmployeeService empbean;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        LoggingGeneral logger = (LoggingGeneral)request.getServletContext().getAttribute("log");
        logger.setEntryPoints(request);
        try {
            Employee emp = empbean.findEmployee(id);
            request.setAttribute("EMP", emp);
            logger.setExitPoints(request);
            RequestDispatcher req = request.getRequestDispatcher("EmployeeUpdate.jsp");
            req.forward(request, response);
        } catch (EJBException ex) {
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean flag = false;
        String eid = request.getParameter("id");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String hiredate = request.getParameter("hdate");
        LoggingGeneral logger = (LoggingGeneral)request.getServletContext().getAttribute("log");
        logger.setEntryPoints(request);
        PrintWriter out = response.getWriter();
// this line is to package the whole values into one array string variable -
// easier just pass one parameter object
        String[] s = { eid, fname, lname, gender, dob, hiredate };
        try {
            if (ValidateManageLogic.validateManager(request).equals("UPDATE")) {
// call session bean updateEmployee method
                empbean.updateEmployee(s);
                flag = true;
            }else if (ValidateManageLogic.validateManager(request).equals("AJAX")) {
                List<Employee> h = empbean.searchEmployeeAjax(eid);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String result = null;
                if (h != null) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.writeValue(out, h);
                } else {
                    out.println(result);
                }
            }
            else if (ValidateManageLogic.validateManager(request).equals("DELETE")) {
// call session bean deleteEmployee method
                empbean.deleteEmployee(eid);
                flag = true;
// if ADD button is clicked
            } else {
// call session bean addEmployee method
                empbean.addEmployee(s);
                flag = true;
            }
// this line is to redirect to notify record has been updated and redirect to
// another page
            logger.setExitPoints(request);
            if(flag) {
                ValidateManageLogic.navigateJS(out);
            }
        } catch (EJBException ex) {
        }
    }}