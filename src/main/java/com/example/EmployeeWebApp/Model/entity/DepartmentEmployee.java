package com.example.EmployeeWebApp.Model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "department_employee", schema = "employees")
public class DepartmentEmployee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private DepartmentEmployeeId id;

    @Column(name = "from_date", nullable = false)
    private Date fromDate;

    @Column(name = "to_date", nullable = false)
    private Date toDate;

    public DepartmentEmployeeId getId() {
        return id;
    }

    public void setId(DepartmentEmployeeId id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

}