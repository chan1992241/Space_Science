package com.example.EmployeeWebApp.controller;

import com.example.EmployeeWebApp.utilities.ReportEmployees;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

@WebServlet(name = "CallableExecutorServlet", value = "/CallableExecutorServlet")
public class CallableExecutorServlet extends HttpServlet {
    @Resource(name = "DefaultManagedExecutorService")
    ManagedExecutorService executor;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ReportEmployees> s1 = new ArrayList<ReportEmployees>();
        s1.add(new ReportEmployees(1));
        s1.add(new ReportEmployees(2));
        s1.add(new ReportEmployees(3));
        List<Future<String>> futureResult = null;
        try {
            futureResult = executor.invokeAll((Collection<ReportEmployees>) s1);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> map=new ArrayList<String>();
        try {
            for(Future<String> future: futureResult)
            {
                map.add(future.get());
            }
            request.setAttribute("RESULTS", map);
            RequestDispatcher req = request.getRequestDispatcher("EmployeeReport.jsp");
            req.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
