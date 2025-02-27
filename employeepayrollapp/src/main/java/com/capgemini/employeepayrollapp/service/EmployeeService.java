package com.capgemini.employeepayrollapp.service;

import com.capgemini.employeepayrollapp.dto.EmployeeDTO;
import com.capgemini.employeepayrollapp.model.Employee;
import com.capgemini.employeepayrollapp.repository.EmployeeRepository;
import com.capgemini.employeepayrollapp.validation.EmployeeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class EmployeeService {

    /* private final EmployeeRepository employeeRepository;

     public EmployeeService(EmployeeRepository employeeRepository) {
         this.employeeRepository = employeeRepository;
     }

     // Convert Employee to EmployeeDTO
     private EmployeeDTO convertToDTO(Employee employee) {
         return new EmployeeDTO(employee.getId(), employee.getName(), employee.getSalary());
     }

     // Convert EmployeeDTO to Employee
     private Employee convertToEntity(EmployeeDTO employeeDTO) {
         return new Employee(employeeDTO.getId(), employeeDTO.getName(), employeeDTO.getSalary());
     }

     // Get All Employees as DTOs
     public List<EmployeeDTO> getAllEmployeesDTO() {
         return employeeRepository.findAll().stream()
                 .map(this::convertToDTO)
                 .collect(Collectors.toList());
     }

     // Get Employee By ID as DTO
     public EmployeeDTO getEmployeeDTOById(Long id) {
         Optional<Employee> employee = employeeRepository.findById(id);
         return employee.map(this::convertToDTO).orElse(null);
     }

     // Add Employee using DTO
     public EmployeeDTO addEmployeeDTO(EmployeeDTO employeeDTO) {
         Employee employee = new Employee(null, employeeDTO.getName(), employeeDTO.getSalary()); // ID auto-generated
         Employee savedEmployee = employeeRepository.save(employee);
         return convertToDTO(savedEmployee);
     }

     // Update Employee
     public EmployeeDTO updateEmployeeDTO(Long id, EmployeeDTO employeeDTO) {
         Optional<Employee> optionalEmployee = employeeRepository.findById(id);
         if (optionalEmployee.isPresent()) {
             Employee employee = optionalEmployee.get();
             employee.setName(employeeDTO.getName());
             employee.setSalary(employeeDTO.getSalary());
             Employee updatedEmployee = employeeRepository.save(employee);
             return convertToDTO(updatedEmployee);
         }
         return null; // Employee not found
     }

     // Delete Employee
     public void deleteEmployeeDTO(Long id) {
         employeeRepository.deleteById(id);
     }*/
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        return repository.save(employee);
    }

    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));

        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setSalary(employeeDTO.getSalary());
        return repository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}