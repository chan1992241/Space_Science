package com.example.EmployeeWebApp.Model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "salary", schema = "employees")
public class Salary {
    @EmbeddedId
    private SalaryId id;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "to_date", nullable = false)
    private Date toDate;

    public SalaryId getId() {
        return id;
    }

    public void setId(SalaryId id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

}