package com.example.EmployeeWebApp.controller;

import com.example.EmployeeWebApp.Model.entity.Employee;
import com.example.EmployeeWebApp.Model.javabean.EmployeeSummary;
import com.example.EmployeeWebApp.Model.sessionbean.EmployeeSessionBeanLocal;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.*;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeSummaryController", value = "/EmployeeSummaryController")
public class EmployeeSummaryController extends HttpServlet {
    @EJB
    private EmployeeSessionBeanLocal empbean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        }
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        EmployeeSummary empsummary = null;
        try{
            empsummary = mapper.readValue(json, EmployeeSummary.class);
        }catch (Exception e){
            System.out.println(e);
        }
        List<Employee> t = empbean.searchEmployeeAjax(empsummary.getId().toString());
        if(t!= null) {
            Employee e = t.get(0);
            empsummary.setFullname(e.getFirstName() + " " + e.getLastName());
            Date date = e.getBirthDate();
            Instant instant = date.toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate givenDate = zone.toLocalDate();
            Period period = Period.between(givenDate, LocalDate.now());
            empsummary.setAge(period.getYears() + " years" + " " + period.getMonths() + " months" + " " + period.getDays() + " days");
            mapper.writeValue(response.getOutputStream(), empsummary);
        }else
        {
            mapper.writeValue(response.getWriter(), t);
        }
    }
}
