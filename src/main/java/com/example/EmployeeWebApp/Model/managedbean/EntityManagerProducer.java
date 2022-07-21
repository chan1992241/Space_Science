package com.example.EmployeeWebApp.Model.managedbean;

import com.example.EmployeeWebApp.Model.entity.Employee;

import javax.ejb.EJBException;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class EntityManagerProducer {
    @Produces
    @PersistenceContext(unitName = "EmployeeWebApp")
    @PostGresDatabase
    private EntityManager em;

    @Inject
    public void EmployeeService(@PostGresDatabase EntityManager em) {
        this.em = em;
    }
    public List<Employee> getAllEmployees() throws EJBException {
        return em.createNamedQuery("Employee.findAll").getResultList();
    }

    public EntityManagerProducer() {
        super();
        // TODO Auto-generated constructor stub
    }
}
