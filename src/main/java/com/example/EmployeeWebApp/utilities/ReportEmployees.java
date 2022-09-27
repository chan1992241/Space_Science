package com.example.EmployeeWebApp.utilities;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedTask;
import javax.enterprise.concurrent.ManagedTaskListener;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class ReportEmployees implements Callable<String>, ManagedTaskListener, ManagedTask {
    private InitialContext ctx;
    private DataSource ds;
    private Connection conn;
    private PreparedStatement query;
    private Integer querytype;
    public ReportEmployees() {
    }
    public ReportEmployees(Integer querytype) {
        this.querytype = querytype;
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:/MyPostGresEmployees");
        } catch (NamingException e) {
// throw new ServletException(e);
        }
    }
    @Override
    public String call() {
        String s = null;
        try {
            conn = ds.getConnection();
            if (querytype == 1) {
                query = conn.prepareStatement(
                        "SELECT COUNT(id) AS \"Total_Emp_Years<10_Age<40\" FROM employees.employee WHERE AGE('2000-06-13', birth_date) < interval '40 years' AND AGE('2000-06-13', hire_date) < interval '10 years'");
            }
            if (querytype == 2) {
                query = conn.prepareStatement(
                        "SELECT COUNT(id) AS \"Total_Emp_Female_Years<10_Age<40\" FROM employees.employee WHERE AGE('2000-06-13', birth_date) < interval '40 years' AND AGE('2000-06-13', hire_date) < interval '10 years' AND gender LIKE 'F'");
            }
            if (querytype == 3) {
                query = conn.prepareStatement(
                        "SELECT COUNT(id) AS \"Total_Emp_Male_Years<5_Age<40\" FROM employees.employee WHERE AGE('2000-06-13', birth_date) < interval '40 years' AND AGE('2000-06-13', hire_date) < interval '5 years' AND gender LIKE 'M'");
            }
            ResultSet set = query.executeQuery();
            ResultSetMetaData resultSetMetaData = set.getMetaData();
            while (set.next()) {
                Long total = set.getLong(resultSetMetaData.getColumnName(1));
                s = resultSetMetaData.getColumnName(1) + ":" + total.toString();
            }
        } catch (SQLException ex) {
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
        return s;
    }
    @Override
    public void taskSubmitted(Future<?> f, ManagedExecutorService es, Object obj) {
        System.out.println("Task Submitted! " + f);
    }
    @Override
    public void taskDone(Future<?> f, ManagedExecutorService es, Object obj, Throwable exc) {
        try {
            System.out.println("Task DONE! ");
        } catch (Exception ex) {
        }
    }
    @Override
    public void taskStarting(Future<?> f, ManagedExecutorService es, Object obj) {
        System.out.println("Task Starting! " + f);
    }
    @Override
    public void taskAborted(Future<?> f, ManagedExecutorService es, Object obj, Throwable exc) {
        System.out.println("Task Aborted! " + f);
    }
    @Override
    public ManagedTaskListener getManagedTaskListener() {
        return this;
    }
    @Override
    public Map<String, String> getExecutionProperties() {
        return new HashMap<>();
    }
}
