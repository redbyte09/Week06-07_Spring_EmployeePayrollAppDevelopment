package com.capgemini.employeepayrollapp.model;


import com.capgemini.employeepayrollapp.dto.EmployeeDTO;
import jakarta.persistence.*;

import lombok.Data;


import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "employee")
public @Data class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    public Long id;

    @Column(name ="name")
    public String name;

    public double salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "Department")
    public List<String> department;

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