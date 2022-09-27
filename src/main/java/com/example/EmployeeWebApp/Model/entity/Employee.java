package com.example.EmployeeWebApp.Model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee", schema = "employees")
@NamedQuery(name = "Employee.findbyId", query = "SELECT e FROM Employee e WHERE e.id = :id")
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
@NamedQuery(name = "Employee.findbyFNameLName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "first_name", nullable = false, length = 14)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 16)
    private String lastName;

    @Column(name = "gender", nullable = false, length = 1)
    private String gender;

    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    public String toJSON() {
        return "Employee{" +
                "id=" + id +
                ", birthDate=" + this.birthDate.toString() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", hireDate=" + hireDate.toString() +
                '}';
    }
}