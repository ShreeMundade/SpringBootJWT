package com.sp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name="Sprint_Emp")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    private String name;
    private String designation;
    private Double salary;
    public Long getEmpId() {
        return empId;
    }
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public Employee(Long empId, String name, String designation, Double salary) {
        super();
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
    public Employee(String name, String designation, Double salary) {
        super();
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
    public Employee() {
        super();
    }
    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + ", salary=" + salary
                + "]";
    }
    
    
    

 

}