package com.capgemini.employeepayrollapp.model;


import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private String name;

    private double salary;

    // No-argument constructor (default)
    public Employee() {
    }

    // Parameterized constructor
    public Employee(String name,  double salary) {

        this.id = id;
        this.name = name;

        this.salary = salary;
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}