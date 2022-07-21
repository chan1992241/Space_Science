package com.example.EmployeeWebApp.Model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "department_manager", schema = "employees")
public class DepartmentManager {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private DepartmentManagerId id;

    @Column(name = "from_date", nullable = false)
    private Date fromDate;

    @Column(name = "to_date", nullable = false)
    private Date toDate;

    public DepartmentManagerId getId() {
        return id;
    }

    public void setId(DepartmentManagerId id) {
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