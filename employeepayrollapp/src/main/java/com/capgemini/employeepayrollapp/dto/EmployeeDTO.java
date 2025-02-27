package com.capgemini.employeepayrollapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Generates Getters, Setters, toString(), equals(), and hashCode()
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;  // ID should not have validation as it's auto-generated for new employees

    @Pattern(regexp = "^[A-Z][a-zA-Z ]{2,}$", message = "Name must start with a capital letter and have at least 3 characters")
    private String name;

    @Positive(message = "Salary must be a positive number")
    private double salary;
}
