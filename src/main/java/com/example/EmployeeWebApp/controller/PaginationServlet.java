package com.example.EmployeeWebApp.controller;

import com.example.EmployeeWebApp.Model.entity.Employee;
import com.example.EmployeeWebApp.Model.managedbean.EmployeeService;
import com.example.EmployeeWebApp.Model.sessionbean.EmployeeSessionBeanLocal;
import com.example.EmployeeWebApp.utilities.LoggingGeneral;

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
import java.util.List;

@WebServlet(name = "PaginationServlet", value = "/PaginationServlet")
public class PaginationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private EmployeeSessionBeanLocal empbean;
//    @Inject
//    private EmployeeService empbean;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nOfPages= 0;
        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int recordsPerPage = Integer.valueOf(request.getParameter("recordsPerPage"));
        String keyword = request.getParameter("keyword");
        String direction = request.getParameter("direction");
        LoggingGeneral logger = (LoggingGeneral)request.getServletContext().getAttribute("log");
        logger.setEntryPoints(request);
        try {
            int rows = empbean.getNumberOfRows(keyword);
            nOfPages = rows / recordsPerPage;
            if (rows % recordsPerPage != 0) {
                nOfPages++;
            }
            if (currentPage > nOfPages && nOfPages != 0) {
                currentPage = nOfPages;
            }
            List<Employee> lists = empbean.readEmployee(currentPage, recordsPerPage, keyword, direction);
            request.setAttribute("staffs", lists);
        } catch (EJBException ex) {
        }
        request.setAttribute("nOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);
        request.setAttribute("keyword", keyword);
        request.setAttribute("direction", direction);
        logger.setExitPoints(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pagination.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}