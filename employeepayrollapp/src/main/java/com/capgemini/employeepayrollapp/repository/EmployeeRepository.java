package com.capgemini.employeepayrollapp.repository;


import com.capgemini.employeepayrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}