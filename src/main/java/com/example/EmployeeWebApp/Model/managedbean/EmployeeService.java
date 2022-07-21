package com.example.EmployeeWebApp.Model.managedbean;

import com.example.EmployeeWebApp.Model.entity.Employee;

import javax.ejb.EJBException;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Dependent  // This employee is depend on other
@Transactional // Treat group of code as one transaction
public class EmployeeService  {
    private EntityManager em;
    @Inject
    public EmployeeService(@PostGresDatabase EntityManager em){
        this.em = em;
    }
    public List<Employee> getAllEmployees() throws EJBException {
        return em.createNamedQuery("Employee.findAll").getResultList();
    }

    public List<Employee> readEmployee(int currentPage, int recordsPerPage, String keyword, String direction) throws
            EJBException {
        Query q = null;
        int start = 0;
        direction = " " + direction;
        if (keyword.isEmpty()) {
            q = em.createNativeQuery("SELECT * FROM employees.employee order by id" + direction , Employee.class);
        }else{
            q = em.createNativeQuery("SELECT * from employees.employee WHERE concat(id,first_name,last_name,gender) LIKE ? order by id" + direction,Employee.class);
            start = currentPage * recordsPerPage - recordsPerPage;
            q.setParameter(1, "%" + keyword + "%");
        }


        List<Employee> results = q.setFirstResult(start).setMaxResults(recordsPerPage).getResultList();
        return results;
    }

    public int getNumberOfRows(String keyword) throws EJBException {
        Query q = null;
        q = em.createNativeQuery("SELECT COUNT(*) AS totalrow FROM employees.employee");
        if (keyword.isEmpty()) {
            q = em.createNativeQuery("SELECT COUNT(*) AS totalrow FROM employees.employee");
        } else {
            q = em.createNativeQuery("SELECT COUNT(*) AS totalrow from employees.employee WHERE concat(id,first_name,last_name,gender) LIKE ?");
            q.setParameter(1, "%" + keyword + "%");
        }
        BigInteger results = (BigInteger) q.getSingleResult();
        int i = results.intValue();
        return i;
    }

    public Employee findEmployee(String id) throws EJBException {
        Query q = em.createNamedQuery("Employee.findbyId");
        q.setParameter("id", Long.valueOf(id));
        return (Employee) q.getSingleResult();
    }

    public void updateEmployee(String[] s) throws EJBException {
        Date dob = null;
        Date hd = null;
        Employee e = findEmployee(s[0]);
        try {
            dob = new SimpleDateFormat("yyyy-MM-dd").parse(s[4]);
            hd = new SimpleDateFormat("yyyy-MM-dd").parse(s[5]);
        } catch (Exception ex) {
        }
        java.sql.Date DOB = new java.sql.Date(dob.getTime());
        java.sql.Date HD = new java.sql.Date(hd.getTime());
        e.setFirstName(s[1]);
        e.setLastName(s[2]);
        e.setGender(s[3]);
        e.setBirthDate(DOB);
        e.setHireDate(HD);
        em.merge(e);
    }

    public void deleteEmployee(String id) throws EJBException {
        Employee e = findEmployee(id);
        em.remove(e);
    }

    public void addEmployee(String[] s) throws EJBException {
        Date dob = null;
        Date hd = null;
        try {
            dob = new SimpleDateFormat("yyyy-MM-dd").parse(s[4]);
            hd = new SimpleDateFormat("yyyy-MM-dd").parse(s[5]);
        } catch (Exception ex) {
        }
        Employee e = new Employee();
        java.sql.Date DOB = new java.sql.Date(dob.getTime());
        java.sql.Date HD = new java.sql.Date(hd.getTime());
        e.setFirstName(s[1]);
        e.setLastName(s[2]);
        e.setGender(s[3]);
        e.setBirthDate(DOB);
        e.setHireDate(HD);
        em.persist(e);
    }
}
