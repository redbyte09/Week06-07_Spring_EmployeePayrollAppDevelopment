package com.capgemini.employeepayrollapp.service;

import com.capgemini.employeepayrollapp.dto.EmployeeDTO;
import com.capgemini.employeepayrollapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeDTO employeeDTO);
    List<Employee> getAllEmployees();
}