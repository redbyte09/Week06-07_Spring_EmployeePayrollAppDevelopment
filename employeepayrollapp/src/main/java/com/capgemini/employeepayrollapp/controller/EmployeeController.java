package com.capgemini.employeepayrollapp.controller;
import com.capgemini.employeepayrollapp.dto.EmployeeDTO;
import com.capgemini.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployeesDTO() {
        return service.getAllEmployeesDTO();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeDTOById(@PathVariable Long id) {
        return service.getEmployeeDTOById(id);
    }

    @PostMapping
    public EmployeeDTO addEmployeeDTO(@RequestBody EmployeeDTO employeeDTO) {
        return service.addEmployeeDTO(employeeDTO);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployeeDTO(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return service.updateEmployeeDTO(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeDTO(@PathVariable Long id) {
        service.deleteEmployeeDTO(id);
    }

}