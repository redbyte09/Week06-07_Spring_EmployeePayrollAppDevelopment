package com.capgemini.employeepayrollapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Generates Getters, Setters, toString(), equals(), and hashCode()
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;  // Use Long to match with the Entity
    private String name;
    private double salary;
}