package com.example.EmployeeWebApp.webservice;

import com.example.EmployeeWebApp.Model.entity.Employee;
import com.example.EmployeeWebApp.Model.javabean.EmployeeWrapper;
import com.example.EmployeeWebApp.Model.sessionbean.EmployeeSessionBeanLocal;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("employee")
@RequestScoped
public class EmployeeWebService {
    @EJB
    private EmployeeSessionBeanLocal empbean;
//10001
    @GET
    @Path("getEmployee/{id:[0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("id") String id) {
        if (empbean.getEmployee(id) != null) {
            return Response.ok(empbean.getEmployee(id).get(0).toJSON()).build();
        } else {
            return Response.status(Response.Status.OK).entity("Employee Not Found").type(MediaType.TEXT_PLAIN).build();
        }
    }
    @POST
    @Path("addEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployee(EmployeeWrapper employee) {
        String[] emp = {"1",employee.getFirstName(),employee.getLastName(),employee.getGender(),employee.getBirthDate(),employee.getHireDate()};
        empbean.addEmployee(emp);
        List<Employee> list = empbean.getEmployeeByName(employee.getFirstName(),employee.getLastName());
        if (list != null) {
            return Response.ok(list.get(0).toJSON()).build();
        } else {
            return Response.status(Response.Status.OK).entity("Employee Not Found").type(MediaType.TEXT_PLAIN).build();
        }
    }
}