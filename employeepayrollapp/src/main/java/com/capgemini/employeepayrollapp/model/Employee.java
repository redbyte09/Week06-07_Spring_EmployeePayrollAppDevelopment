package com.capgemini.employeepayrollapp.model;


import com.capgemini.employeepayrollapp.dto.EmployeeDTO;
import jakarta.persistence.*;

import lombok.Data;


import java.util.List;


@Entity
@Table(name = "employee")
public @Data class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public double salary;
    public String gender;
    public String startDate;
    public String note;
    public String profilePic;
    public String department;

    public Employee() {}

    public Employee(EmployeeDTO employeeDTO) {
        this.id =employeeDTO.id;
        this.name = employeeDTO.name;
        this.salary = employeeDTO.salary;
        this.gender = employeeDTO.gender;
        this.note = employeeDTO.note;
        this.startDate = employeeDTO.startDate;
        this.profilePic = employeeDTO.profilePic;
        this.department = employeeDTO.department;
    }

}