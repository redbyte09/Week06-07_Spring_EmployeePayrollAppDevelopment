package com.capgemini.employeepayrollapp.service;
import com.capgemini.employeepayrollapp.dto.EmployeeDTO;
import com.capgemini.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // List to store employees in memory (temporary storage)
    private final List<Employee> employeeList = new ArrayList<>();

    // Simulates an auto-increment ID for employees
    private final AtomicLong idCounter = new AtomicLong(1);

    /**
     * Creates a new employee and adds it to the list.
     */
    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(idCounter.getAndIncrement()); // Assign a unique ID
        employee.setName(employeeDTO.getName()); // Set employee name
        employee.setSalary(employeeDTO.getSalary()); // Set employee salary

        employeeList.add(employee); // Add employee to the list
        return employee;
    }

    /**
     * Returns the list of all employees.
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }


    @Override
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        // Find the employee with the given ID
        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                // Update employee details
                employee.setName(employeeDTO.getName());
                employee.setSalary(employeeDTO.getSalary());
                return employee;
            }
        }
        // If employee is not found, throw an error
        throw new RuntimeException("Employee with ID " + id + " not found.");
    }

    /**
     * Deletes an employee based on ID.
     */
    @Override
    public void deleteEmployee(Long id) {
        employeeList.removeIf(employee -> employee.getId().equals(id));
    }
}